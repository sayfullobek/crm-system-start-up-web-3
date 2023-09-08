package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.IncomeStatisticControllerImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.IncomeStatisticDto;
import it.ul.team.crmsystemstartup.service.IncomeStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/income-statistic")
@CrossOrigin
public class IncomeStatisticController implements it.ul.team.crmsystemstartup.implement.ControllerImplement.IncomeStatisticControllerImplement {

    @Override
    @GetMapping
    public HttpEntity<?> getIncomeStatistic() {
        List<IncomeStatisticDto> incomeStatistic = service.getIncomeStatistic();
        return ResponseEntity.ok(incomeStatistic);
    }

    @Override
    @PostMapping
    public HttpEntity<?> addIncomeStatistic(@RequestBody IncomeStatisticDto incomeStatisticDto) {
        ApiResponse<?> apiResponse = service.addIncomeStatistic(incomeStatisticDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @PutMapping("/{id}")
    public HttpEntity<?> editIncomeStatistic(@PathVariable UUID id, @RequestBody IncomeStatisticDto incomeStatisticDto) {
        ApiResponse<?> apiResponse = service.editIncomeStatistic(id, incomeStatisticDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteIncomeStatistic(@PathVariable UUID id) {
        ApiResponse<?> apiResponse = service.deleteIncomeStatistic(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    public HttpEntity<?> getOneIncomeStatistic(UUID id) {
        return null;
    }
}
