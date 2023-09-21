package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.MonthlyEmployerIncomeControllerImpl;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/monthly-employer-income")
public class MonthlyEmployerIncomeController implements MonthlyEmployerIncomeControllerImpl {
    @Override
    @GetMapping
    public HttpEntity<?> getMonthlyEmployerIncome() {
        return null;
    }

    @Override
    @PostMapping
    public HttpEntity<?> addMonthlyEmployerIncome(IncomeStatisticDto incomeStatisticDto) {
        return null;
    }
}
