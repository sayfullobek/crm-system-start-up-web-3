package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.IncomeStatistic;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.IncomeStatisticServiceImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import it.ul.team.crmsystemstartup.repository.IncomeStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncomeStatisticService implements IncomeStatisticServiceImplement {

    private final IncomeStatisticRepository incomeStatisticRepository;

    @Override
    public List<IncomeStatisticDto> getIncomeStatistic() {
        List<IncomeStatistic> all = incomeStatisticRepository.findAll();
        List<IncomeStatisticDto> incomeStatisticDto = new ArrayList<>();
        for (IncomeStatistic incomeStatistic : all) {
            incomeStatisticDto.add(getIncomeStatisticBuild(incomeStatistic));
        }
        return incomeStatisticDto;
    }

    @Override
    public ApiResponse<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto) {
        try {
            IncomeStatistic incomeStatistic = IncomeStatistic.builder()
                    .allS(incomeStatisticDto.getAllS())
                    .monthly(incomeStatisticDto.getMonthly())
                    .allS_cost(incomeStatisticDto.getAllS_cost())
                    .monthly_cost(incomeStatisticDto.getMonthly_cost())
                    .build();
            incomeStatisticRepository.save(incomeStatistic);
            return new ApiResponse<>("Saqlandi😎", true);
        }catch (Exception e){
            return new ApiResponse<>("saqlashda xatolik😵", false);
        }
    }

    public IncomeStatisticDto getIncomeStatisticBuild(IncomeStatistic incomeStatistic){
        return IncomeStatisticDto.builder()
                .id(incomeStatistic.getId())
                .allS(incomeStatistic.getAllS())
                .monthly(incomeStatistic.getMonthly())
                .allS_cost(incomeStatistic.getAllS_cost())
                .monthly_cost(incomeStatistic.getMonthly_cost())
                .build();
    }
}
