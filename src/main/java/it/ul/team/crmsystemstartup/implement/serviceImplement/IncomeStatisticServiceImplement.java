package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;

import java.util.List;
import java.util.UUID;

public interface IncomeStatisticServiceImplement {
    List<IncomeStatisticDto> getIncomeStatistic();
    ApiResponse<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto);
}
