package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.entity.Payment;
import it.ul.team.crmsystemstartup.implement.controllerImplement.PaymentControllerImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController implements PaymentControllerImpl {

    private final PaymentService paymentService;
    @Override
    public HttpEntity<?> getPayment() {
        List<PaymentDto> payment = paymentService.getPayment();
        return ResponseEntity.ok(payment);
    }

    @Override
    public HttpEntity<?> addPayment(PaymentDto paymentDto) {
        ApiResponse<?> apiResponse = paymentService.addPayment(paymentDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @Override
    public HttpEntity<?> editPayment(UUID id, PaymentDto paymentDto) {
        ApiResponse<?> apiResponse = paymentService.editPayment(id, paymentDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);


    }


}
