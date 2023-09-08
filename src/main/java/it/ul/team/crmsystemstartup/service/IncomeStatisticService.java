package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.implement.serviceImplement.IncomeStatisticServiceImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncomeStatisticService implements IncomeStatisticServiceImplement {

    @Override
    public List<IncomeStatisticDto> getIncomeStatistic() {
        return null;
    }

    @Override
    public ApiResponse<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public ApiResponse<?> editIncomeStatistic(UUID id, IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteIncomeStatistic(UUID id) {
        return null;
    }

    @Override
    public ApiResponse<?> getOneIncomeStatistic(UUID id) {
        return null;
    }

}
