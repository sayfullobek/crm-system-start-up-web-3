package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;

import java.util.List;
import java.util.UUID;

public interface PaymentServiceImpl {
    List<PaymentDto> getPayment();
    ApiResponse<?> addPayment(PaymentDto paymentDto);
    ApiResponse<?> editPayment(UUID id, PaymentDto paymentDto);
}
