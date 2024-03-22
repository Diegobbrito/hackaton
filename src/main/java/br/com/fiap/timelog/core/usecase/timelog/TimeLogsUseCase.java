package br.com.fiap.timelog.core.usecase.timelog;

import br.com.fiap.timelog.api.dto.response.ReportResponse;
import br.com.fiap.timelog.api.dto.request.TimeLogsRequest;
import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;
import br.com.fiap.timelog.api.exception.TimeLogException;
import br.com.fiap.timelog.core.entity.TimeLogs;
import br.com.fiap.timelog.core.usecase.email.IEnviarEmailCliente;
import br.com.fiap.timelog.infra.repository.TimeLogsRepository;
import br.com.fiap.timelog.infra.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class TimeLogsUseCase implements ITimeLogs {

    private final TimeLogsRepository repository;
    private final UserRepository userRepository;

    private final IEnviarEmailCliente enviarEmailCliente;

    public TimeLogsUseCase(TimeLogsRepository repository, UserRepository userRepository, IEnviarEmailCliente enviarEmailCliente) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.enviarEmailCliente = enviarEmailCliente;
    }

    @Override
    public void createRegistry(TimeLogsRequest request) {
        var timestamp = Timestamp.from(Instant.now());
        var usuario = userRepository.findById(request.userId());
        if (usuario.isEmpty()){
            throw new RuntimeException("Usuario não encontrado");
        }

        repository
                .findLastLogByUserId(request.userId())
                .ifPresent(timeLogs -> hasAMinuteDifference(timestamp, timeLogs.getTimeStampRegistry()));

        TimeLogs timeLogs = TimeLogs.builder()
                .userId(request.userId())
                .timeStampRegistry(timestamp)
                .build();

        repository.save(timeLogs);
    }

    @Override
    public List<TimeLogsResponse> getRegistriesByDate(Long userId, String date) {
        var format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var timelogs = repository.findAllByUserIdAndDate(userId, LocalDate.parse(date, format));

        return sortByDate(timelogs);
    }

    @Override
    public ReportResponse generateReport(Long userId, String userEmail) {

        LocalDate date = LocalDate.now().minusMonths(1);
        var timeLogs = repository.findAllByUserIdAndLastMonth(userId, date);

        final var report = sortByDate(timeLogs);
        enviarEmailCliente.enviarEmail(userEmail, report, date);
        return new ReportResponse("O report será enviado para o email: ");
    }

    private List<TimeLogsResponse> sortByDate(List<TimeLogs> timeLogs) {
        Map<String, List<TimeLogs>> logsByDay = timeLogs.stream()
                .collect(Collectors.groupingBy(log ->
                        log.getTimeStampRegistry().toLocalDateTime().toLocalDate().toString()));
        return logsByDay.values().stream()
                .sorted(Comparator.comparing(c -> c.get(0).getTimeStampRegistry()))
                .map(this::toResponseTimeLogs)
                .toList();
    }

    private TimeLogsResponse toResponseTimeLogs(List<TimeLogs> timelogs) {

        List<String> response =  new ArrayList<>(1);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE - 'Dia: 'dd/MM/yy' - Horário: 'HH:mm:ss");

        timelogs.forEach(timeLog ->
            response.add(StringUtils.capitalize(format.format(timeLog.getTimeStampRegistry().toLocalDateTime())))
        );

        String totalHours = calculateTotalHours(timelogs);

        return new TimeLogsResponse(response, totalHours);
    }

    private String calculateTotalHours(List<TimeLogs> logs) {
        BigDecimal totalHours = BigDecimal.ZERO;

            if(logs.size() % 2 != 0){
                logs.remove(logs.size() - 1);
            }
            for (int i = 0; i < logs.size(); i+=2) {
                var checkIn = logs.get(i).getTimeStampRegistry();
                var checkOut = logs.get(i +1).getTimeStampRegistry();
                long diffInMillis = checkOut.getTime() - checkIn.getTime();

                totalHours = totalHours.add(new BigDecimal( diffInMillis / 3600000.0));
            }

        return totalHours.setScale(2, RoundingMode.FLOOR).toString();
    }

    private void hasAMinuteDifference(Timestamp now, Timestamp lastLog) {
        long differenceInMinutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - lastLog.getTime());
        if(differenceInMinutes < 1)
            throw new TimeLogException("Ultimo registro em menos de 1 minutos");
    }
}
