package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.implement.serviceImplement.IncomeStatisticServiceImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeStatisticService implements it.ul.team.crmsystemstartup.implement.ServiceImplement.IncomeStatisticServiceImplement {

    @Override
    public List<IncomeStatisticDto> getIncomeStatistic() {
        return null;
    }

    @Override
    public ApiResponse<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public ApiResponse<?> editIncomeStatistic(Integer id, IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteIncomeStatistic(Integer id) {
        return null;
    }

    @Override
    public ApiResponse<?> getOneIncomeStatistic(Integer id) {
        return null;
    }
}
