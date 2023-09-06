package it.ul.team.crmsystemstartup.implement.ServiceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;

import java.util.List;

public interface IncomeStatisticServiceImplement {
    List<IncomeStatisticDto> getIncomeStatistic();
    ApiResponse<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto);
    ApiResponse<?> editIncomeStatistic(Integer id, IncomeStatisticDto incomeStatisticDto);
    ApiResponse<?> deleteIncomeStatistic(Integer id);
    ApiResponse<?> getOneIncomeStatistic(Integer id);
}
