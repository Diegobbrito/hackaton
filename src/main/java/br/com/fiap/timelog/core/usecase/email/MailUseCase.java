package br.com.fiap.timelog.core.usecase.email;

import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;
import br.com.fiap.timelog.api.exception.UserException;
import br.com.fiap.timelog.infra.dataprovider.MailDataProvider;
import br.com.fiap.timelog.infra.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
public class MailUseCase implements IMail {

    private final UserRepository repository;

    private final MailDataProvider mailDataProvider;

    public MailUseCase(UserRepository repository, MailDataProvider mailDataProvider) {
        this.repository = repository;
        this.mailDataProvider = mailDataProvider;
    }

    private static final  String TABLE_LINE = "<tr><td>";
    private static final String TABLE_LINE_CLOSE = "<tr><td>";


    @Override
    public void sendMail(String email, List<TimeLogsResponse> report, LocalDate localDate) {
        var user = repository.findByEmail(email);
        if(user.isEmpty())
            throw new UserException("Usuário não encontrado");

        var title = "Olá " + user.get().getUsername() + ", seu relatório de ponto foi gerado.";

        BigDecimal totalMonthHours = BigDecimal.ZERO;
        StringBuilder reportToSent = new StringBuilder();
        reportToSent.append("<h1>Relatório de Ponto</h1").append("<br/>")
                .append("<p>Aqui está seu relatório de ponto do mês de ")
                .append(StringUtils.capitalize(localDate.getMonth().getDisplayName(TextStyle.FULL,  new Locale("pt", "BR"))))
                .append(" de ").append(localDate.getYear()).append("</p>")
                .append("<table border='1'>");


        for (TimeLogsResponse timeLog : report) {
            totalMonthHours = totalMonthHours.add(new BigDecimal(timeLog.totalHours()));
            timeLog.dateTime().forEach(log ->
                        reportToSent.append(TABLE_LINE)
                                .append(log)
                                .append(TABLE_LINE_CLOSE)
            );
            reportToSent.append(TABLE_LINE + "Total de horas no dia: ")
                    .append(timeLog.totalHours())
                    .append(TABLE_LINE_CLOSE);
        }

        reportToSent.append(TABLE_LINE + "Total de horas no Mês: ")
                .append(totalMonthHours.setScale(2, RoundingMode.HALF_UP))
                .append(TABLE_LINE_CLOSE);

        mailDataProvider.sendEmail(email, title, reportToSent.toString());
    }
}
