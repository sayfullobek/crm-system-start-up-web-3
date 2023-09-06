package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.IncomeStatisticControllerImplement;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/income-statistic")
@CrossOrigin
public class IncomeStatisticController implements IncomeStatisticControllerImplement {

    @Override
    public HttpEntity<?> getIncomeStatistic() {
        return null;
    }

    @Override
    public HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public HttpEntity<?> editIncomeStatistic(Integer id, IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public HttpEntity<?> deleteIncomeStatistic(Integer id) {
        return null;
    }

    @Override
    public HttpEntity<?> getOneIncomeStatistic(Integer id) {
        return null;
    }
}
