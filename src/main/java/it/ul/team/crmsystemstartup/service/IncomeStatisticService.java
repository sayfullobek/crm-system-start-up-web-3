package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.implement.ServiceImplement.IncomeStatisticServiceImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeStatisticService implements IncomeStatisticServiceImplement {
    @Override
    public List<IncomeStatisticDto> getIncomeStatistic() {
        return null;
    }

    @Override
    public ApiResponse<?> addCountry(IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public ApiResponse<?> editCountry(Integer id, IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteCountry(Integer id) {
        return null;
    }

    @Override
    public ApiResponse<?> getOneCountry(Integer id) {
        return null;
    }
}
