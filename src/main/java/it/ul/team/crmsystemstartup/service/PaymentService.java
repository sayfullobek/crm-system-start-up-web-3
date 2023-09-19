package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Group;
import it.ul.team.crmsystemstartup.entity.Payment;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.repository.GroupRepository;
import it.ul.team.crmsystemstartup.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final AuthRepository authRepository;
    private final GroupRepository groupRepository;

    public List<PaymentDto> getPayment(UUID userId) {
        User user = authRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user"));
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment : user.getPayment()) {
            PaymentDto build = PaymentDto.builder()
                    .payTypes(payment.getPayType())
                    .sum(payment.getSum())
                    .date(payment.getDate())
                    .build();
            paymentDtos.add(build);
        }
        return paymentDtos;
    }

    public ApiResponse<?> addPayment(PaymentDto paymentDto) {
        try {

            Group group = groupRepository.findById(paymentDto.getGroupId()).orElseThrow(() -> new ResourceNotFoundException( "getGroup"));
            User user = authRepository.findById(paymentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException( "getUser"));
            for (User user1 : group.getPupil()) {
                if (user1 == user) {
                    Payment build = Payment.builder()
                            .student(paymentDto.getStudent())
                            .payType(paymentDto.getPayTypes())
                            .sum(paymentDto.getSum())
                            .date(paymentDto.getDate())
                            .build();
                    paymentRepository.save(build);
                    new ApiResponse<>("Tolandi",true);
                }
            }
            return new ApiResponse<>(" Xatolik", false);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    public ApiResponse<?> editPayment(UUID id, PaymentDto paymentDto) {
        try {
            Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getPayment"));
            payment.setStudent(paymentDto.getStudent());
            payment.setSum(paymentDto.getSum());
            payment.setPayType(paymentDto.getPayTypes());
            payment.setDate(paymentDto.getDate());
            paymentRepository.save(payment);
            return new ApiResponse<>("taxrirlandi", true);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }


}
