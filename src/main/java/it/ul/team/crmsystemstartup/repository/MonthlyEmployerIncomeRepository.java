package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.IncomeStatistic;
import it.ul.team.crmsystemstartup.entity.MonthlyEmployerIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface MonthlyEmployerIncomeRepository extends JpaRepository<MonthlyEmployerIncome, UUID> {
    @Query("select income from  MonthlyEmployerIncome income where income.month=?1")
    Optional<MonthlyEmployerIncome> findMonthlyEmployerIncomeByMonth(String month);
    Optional<MonthlyEmployerIncome> findMonthlyEmployerIncomeByTeachersId(UUID teachers_id);

}
