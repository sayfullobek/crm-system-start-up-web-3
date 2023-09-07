package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface IncomeStatisticControllerImplement {
    HttpEntity<?> getIncomeStatistic();
    HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto);
    HttpEntity<?> editIncomeStatistic(UUID id, IncomeStatisticDto incomeStatisticDto);
    HttpEntity<?> deleteIncomeStatistic(UUID id);
    HttpEntity<?> getOneIncomeStatistic(UUID id);
}
