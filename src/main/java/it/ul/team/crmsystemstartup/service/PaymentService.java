package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Payment;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.PaymentServiceImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.repository.CourseRepository;
import it.ul.team.crmsystemstartup.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceImpl {

    private final PaymentRepository paymentRepository;
    private final AuthRepository authRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<PaymentDto> getPayment() {
        List<Payment> all = paymentRepository.findAll();
        List<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment : all) {
            PaymentDto build = PaymentDto.builder()
                    .student(payment.getStudent())
                    .sum(payment.getSum())
                    .payTypes(payment.getPayType())
                    .date(payment.getDate())
                    .build();
            paymentDtos.add(build);
        }
        return paymentDtos;
    }

    @Override
    public ApiResponse<?> addPayment(PaymentDto paymentDto) {
        try {
            User user = authRepository.findById(paymentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(404, "getUser", "userId", paymentDto.getUserId()));
            Payment build = Payment.builder()
                    .student(paymentDto.getStudent())
                    .sum(paymentDto.getSum())
                    .date(paymentDto.getDate())
                    .payType(paymentDto.getPayTypes())
                    .build();
            paymentRepository.save(build);
            return new ApiResponse<>("tolandi", true);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

//    public ApiResponse<?> addPayment(PaymentDto paymentDto) {
//        try {
//            User user = authRepository.findById(paymentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(404, "user", "id", paymentDto.getUserId()));
//
//            Course course = courseRepository.findById(paymentDto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException(404, "course", "courseId", paymentDto.getCourseId()));
//            for (Course course1 : user.getCourses()) {
//                if (course == course1) {
//                    Payment build = Payment.builder()
//                            .student(user.getFirstName() + " " + user.getLastName())
//                            .payType(paymentDto.getPayTypes())
//                            .sum(paymentDto.getSum())
////                double percentPrice = (product.getPrice() / 100) * salePercent;
////                product.setPrice(product.getPrice()-percentPrice);
//                            .date(paymentDto.getDate())
//                            .build();
//                    paymentRepository.save(build);
//                    user.getPayment().add(build);
//                    return new ApiResponse<>("Tolandi", true);
//                }
//                return new ApiResponse<>("bunday kurs mavjud emas", false);
//            }
//            return new ApiResponse<>("topilmadi", false);
//        } catch (Exception e) {
//            return new ApiResponse<>("Xatolik", false);
//        }
//    }

    @Override
    public ApiResponse<?> editPayment(UUID id, PaymentDto paymentDto) {
        try {
            Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getPayment", "payment", id));
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
