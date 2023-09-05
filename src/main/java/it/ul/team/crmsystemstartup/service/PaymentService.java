package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.implement.serviceImplement.PaymentServiceImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceImpl {
    private final PaymentRepository paymentRepository;
    @Override
    public List<PaymentDto> getCountry() {
        return null;
    }

    @Override
    public ApiResponse<?> addCountry(PaymentDto paymentDto) {
        return null;
    }

    @Override
    public ApiResponse<?> editCountry(UUID id, PaymentDto paymentDto) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteCountry(UUID id) {
        return null;
    }

    @Override
    public ApiResponse<?> getOneCountry(UUID id) {
        return null;
    }
}
