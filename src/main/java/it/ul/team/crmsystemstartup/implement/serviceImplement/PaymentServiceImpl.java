package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;

import java.util.List;
import java.util.UUID;

public interface PaymentServiceImpl {
    List<PaymentDto> getCountry();
    ApiResponse<?> addCountry(PaymentDto paymentDto);
    ApiResponse<?> editCountry(UUID id, PaymentDto paymentDto);
    ApiResponse<?> deleteCountry(UUID id);
    ApiResponse<?> getOneCountry(UUID id);
}
