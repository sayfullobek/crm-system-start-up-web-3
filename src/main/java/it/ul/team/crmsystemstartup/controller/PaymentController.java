package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.entity.Payment;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.repository.PaymentRepository;
import it.ul.team.crmsystemstartup.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import java.util.List;


@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    @GetMapping()
    public HttpEntity<?> getAll(){
        List<Payment> all = paymentRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getPayment(@PathVariable UUID id) {
        List<PaymentDto> payment = paymentService.getPayment(id);
        return ResponseEntity.ok(payment);
    }

    @PostMapping
    public HttpEntity<?> addPayment(PaymentDto paymentDto) {
        ApiResponse<?> apiResponse = paymentService.addPayment(paymentDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}

