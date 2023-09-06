package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.ControllerImplement.IncomeStatisticControllerImplement;
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
    public HttpEntity<?> getCountry() {
        return null;
    }

    @Override
    public HttpEntity<?> addCountry(IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public HttpEntity<?> editCountry(Integer id, IncomeStatisticDto incomeStatisticDto) {
        return null;
    }

    @Override
    public HttpEntity<?> deleteCountry(Integer id) {
        return null;
    }

    @Override
    public HttpEntity<?> getOneCountry(Integer id) {
        return null;
    }
}
