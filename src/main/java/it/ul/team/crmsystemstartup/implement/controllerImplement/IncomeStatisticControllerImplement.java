package it.ul.team.crmsystemstartup.implement.ControllerImplement;

import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import org.springframework.http.HttpEntity;

public interface IncomeStatisticControllerImplement {
    HttpEntity<?> getIncomeStatistic();
    HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto);
    HttpEntity<?> editIncomeStatistic(Integer id, IncomeStatisticDto incomeStatisticDto);
    HttpEntity<?> deleteIncomeStatistic(Integer id);
    HttpEntity<?> getOneIncomeStatistic(Integer id);
}
