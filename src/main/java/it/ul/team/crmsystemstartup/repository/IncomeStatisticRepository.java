package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.IncomeStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncomeStatisticRepository extends JpaRepository<IncomeStatistic, UUID> {
}
