package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import java.util.List;

import static springfox.documentation.schema.ScalarType.UUID;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public HttpEntity<?> getPayment(@RequestParam UUID userId) {
        List<PaymentDto> payment = paymentService.getPayment(userId);
        return ResponseEntity.ok(payment);
    }

    @PostMapping
    public HttpEntity<?> addPayment(PaymentDto paymentDto) {
        ApiResponse<?> apiResponse = paymentService.addPayment(paymentDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}

