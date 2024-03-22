package br.com.fiap.timelog.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name = "timelogs")
@Entity(name = "timelogs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TimeLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    Timestamp timeStampRegistry;

}
