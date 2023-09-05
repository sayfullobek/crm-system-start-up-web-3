package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.PaymentDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface PaymentControllerImpl {
        HttpEntity<?> getPayment();
        HttpEntity<?> addPayment(PaymentDto paymentDto);
        HttpEntity<?> editPayment(UUID id,PaymentDto paymentDto);
}
