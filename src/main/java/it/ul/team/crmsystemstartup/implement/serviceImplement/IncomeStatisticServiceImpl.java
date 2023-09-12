package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface IncomeStatisticServiceImpl {
    List<IncomeStatisticDto> getIncomeStatistic();
    HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto);
}
