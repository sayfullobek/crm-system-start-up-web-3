package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.IncomeStatistic;
import it.ul.team.crmsystemstartup.entity.Payment;
import it.ul.team.crmsystemstartup.implement.serviceImplement.IncomeStatisticServiceImpl;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import it.ul.team.crmsystemstartup.repository.IncomeStatisticRepository;
import it.ul.team.crmsystemstartup.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IncomeStatisticService implements IncomeStatisticServiceImpl {
    private final IncomeStatisticRepository incomeStatisticRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public List<IncomeStatisticDto> getIncomeStatistic() {
        List<IncomeStatistic> all = incomeStatisticRepository.findAll();
        List<IncomeStatisticDto> incomeStatisticDtoList = new ArrayList<>();
        for (IncomeStatistic statistic : all) {

        }
        return incomeStatisticDtoList;
    }

    @Override
    public HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto) {
        List<Payment> paymentList = paymentRepository.findAll();
        for (Payment payment : paymentList) {
            Double sum = payment.getSum();
            if (sum != 0) {
                IncomeStatistic.builder()
                        .allS(sum)
                        .monthly(sum)
                        .build();
            }
        }
        return null;
    }

    public IncomeStatisticDto getIncomeStatisticBuilder(IncomeStatistic incomeStatistic) {
        return IncomeStatisticDto.builder()
                .allS(incomeStatistic.getAllS())
                .monthly(incomeStatistic.getMonthly())
                .allS_cost(incomeStatistic.getAllS_cost())
                .monthly_cost(incomeStatistic.getMonthly_cost())
                .build();
    }
}
