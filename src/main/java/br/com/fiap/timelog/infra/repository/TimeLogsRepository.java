package br.com.fiap.timelog.infra.repository;

import br.com.fiap.timelog.core.entity.TimeLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeLogsRepository extends JpaRepository<TimeLogs, Long> {

    @Query("SELECT t FROM TimeLogs t WHERE t.userId = :userId ORDER BY t.timeStampRegistry DESC LIMIT 1")
    Optional<TimeLogs> findLastLogByUserId(@Param("userId") Long userId);

    @Query("""
            SELECT t FROM TimeLogs t
            WHERE t.userId = :userId
            AND DAY(t.timeStampRegistry) = DAY(:date)
            AND MONTH(t.timeStampRegistry) = MONTH(:date)
            AND YEAR(t.timeStampRegistry) = YEAR(:date)
            """)
    List<TimeLogs> findAllByUserIdAndDate(@Param("userId") Long userId, @Param("date") LocalDate date);
    @Query("""
            SELECT t FROM TimeLogs t
            WHERE t.userId = :userId
            AND MONTH(t.timeStampRegistry) = MONTH(:date)
            AND YEAR(t.timeStampRegistry) = YEAR(:date)
            """)
    List<TimeLogs> findAllByUserIdAndLastMonth(Long userId, LocalDate date);
}
