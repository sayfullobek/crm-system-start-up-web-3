package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.*;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final AuthRepository authRepository;
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final IncomeStatisticRepository incomeStatisticRepository;

    public List<PaymentDto> getPayment(UUID userId) {
        User user = authRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(404,"getUser","user",userId));
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
            Group group = groupRepository.findById(paymentDto.getGroupId()).orElseThrow(() -> new ResourceNotFoundException(404, "getGroup","group",paymentDto.getGroupId()));
            User user = authRepository.findById(paymentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(404, "getUser","user",paymentDto.getUserId()));
            for (User user1 : group.getPupil()) {
                if (user1 == user) {
                    Payment build = Payment.builder()
                            .student(paymentDto.getStudent())
                            .sum(paymentDto.getSum())
                            .payType(paymentDto.getPayTypes())
                            .sum(paymentDto.getSum())
                            .date(paymentDto.getDate())
                            .build();
                    paymentRepository.save(build);
                    if (LocalDate.now().toString().substring(5, 7).equals(paymentDto.getDate().substring(5, 7))) {
                        IncomeStatistic statistic = incomeStatisticRepository.findIncomeStatisticByNowDate(LocalDate.now()).orElseThrow(() -> new ResourceNotFoundException(404, "income", "id", 1));
                        statistic.setMonthly(statistic.getMonthly() + paymentDto.getSum());
                        statistic.setAllS(statistic.getAllS() + paymentDto.getSum());
                        incomeStatisticRepository.save(statistic);
                        new ApiResponse<>("Tolandi", true);
                    } else {
                        IncomeStatistic build1 = IncomeStatistic.builder()
                                .monthly(paymentDto.getSum())
                                .allS(paymentDto.getSum())
                                .nowDate(LocalDate.parse(paymentDto.getDate()))
                                .build();
                        incomeStatisticRepository.save(build1);
                        new ApiResponse<>("Tolandi", true);
                    }
                }
            }
            return new ApiResponse<>(" Xatolik", false);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    public ApiResponse<?> editPayment(UUID id, PaymentDto paymentDto) {
        try {
            Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404,"getPayment","payment",id));
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
