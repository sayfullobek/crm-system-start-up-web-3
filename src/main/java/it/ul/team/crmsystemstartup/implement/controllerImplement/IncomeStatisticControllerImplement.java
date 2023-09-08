package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import org.springframework.http.HttpEntity;

public interface IncomeStatisticControllerImplement {
    HttpEntity<?> getIncomeStatistic();
    HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto);
}
