package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.IncomeStatisticControllerImpl;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import it.ul.team.crmsystemstartup.service.IncomeStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income-statistic")
public class IncomeStatisticController implements IncomeStatisticControllerImpl {
    private final IncomeStatisticService service;
    @Override
    @GetMapping
    public HttpEntity<?> getIncomeStatistic() {
        List<IncomeStatisticDto> incomeStatistic = service.getIncomeStatistic();
        return ResponseEntity.ok(incomeStatistic);
    }

    @Override
    @PostMapping
    public HttpEntity<?> addIncomeStatistic(IncomeStatisticDto incomeStatisticDto) {
        return service.addIncomeStatistic(incomeStatisticDto);
    }
}
