package br.com.fiap.timelog.api.controller;

import br.com.fiap.timelog.api.dto.response.ReportResponse;
import br.com.fiap.timelog.api.dto.request.TimeLogsRequest;
import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;
import br.com.fiap.timelog.api.exception.UserException;
import br.com.fiap.timelog.core.security.JwtTokenService;
import br.com.fiap.timelog.core.usecase.timelog.ITimeLogs;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Tag(name = "TimeLogs", description = "Management of log time of a user")
public class TimeLogsController {

    private final ITimeLogs timeClockUseCase;
    private final JwtTokenService jwtTokenService;

    public TimeLogsController(ITimeLogs timeClockUseCase, JwtTokenService jwtTokenService) {
        this.timeClockUseCase = timeClockUseCase;
        this.jwtTokenService = jwtTokenService;
    }
    @Operation(summary = "Create a log time registry")
    @PostMapping("/log-time")
    public ResponseEntity<Void> createRegistry(@RequestBody TimeLogsRequest request, @RequestHeader("Authorization") String authorization){
        var userId = jwtTokenService.getUserIdFromToken(authorization);
        if(!Objects.equals(userId, request.userId()))
            throw new UserException("Usuário não autenticado difere do usuário solicitado");

        timeClockUseCase.createRegistry(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "List the registrations of a day")
    @GetMapping("/log-time")
    public ResponseEntity<List<TimeLogsResponse>> getRegistriesByDate(
            @Schema(example = "615243")
            @RequestParam("date") String date,
            @RequestHeader("Authorization") String authorization) {
        var userId = jwtTokenService.getUserIdFromToken(authorization);
        List<TimeLogsResponse> response = timeClockUseCase.getRegistriesByDate(userId, date);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Generate a report sent by email to the email of the user")
    @GetMapping("/report")
    public ResponseEntity<ReportResponse> generateReport(@RequestHeader("Authorization") String authorization) {
        var userId = jwtTokenService.getUserIdFromToken(authorization);
        var email = jwtTokenService.getSubjectFromToken(authorization);
        ReportResponse response = timeClockUseCase.generateReport(userId, email);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
