package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import it.ul.team.crmsystemstartup.payload.MonthlyEmployerIncomeDto;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface MonthlyEmployerIncomeServiceImpl {
    List<MonthlyEmployerIncomeDto> getMonthlyEmployerIncome();
    ApiResponse<?> addMonthlyEmployerIncome(MonthlyEmployerIncomeDto monthlyEmployerIncomeDto);

}
