package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.PaymentControllerImpl;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController implements PaymentControllerImpl {

    private final PaymentService paymentService;
    @Override
    public HttpEntity<?> getPayment() {
        return null;
    }

    @Override
    public HttpEntity<?> addPayment(PaymentDto paymentDto) {
        return null;
    }

    @Override
    public HttpEntity<?> editPayment(UUID id, PaymentDto paymentDto) {
        return null;
    }


}
