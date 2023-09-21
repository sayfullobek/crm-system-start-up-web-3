package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.IncomeStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface IncomeStatisticRepository extends JpaRepository<IncomeStatistic, UUID> {
    @Query("select income from  income_statistic income where income.nowDate=?1")
    Optional<IncomeStatistic> findIncomeStatisticByNowDate(LocalDate localDate);
}
