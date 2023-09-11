package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Course;
import it.ul.team.crmsystemstartup.entity.Group;
import it.ul.team.crmsystemstartup.entity.Payment;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.PaymentDto;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.repository.CourseRepository;
import it.ul.team.crmsystemstartup.repository.GroupRepository;
import it.ul.team.crmsystemstartup.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<PaymentDto> getPayment(UUID userId) {
        User user = authRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(404, "user", "id", userId));
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

            Group group = groupRepository.findById(paymentDto.getGroupId()).orElseThrow(() -> new ResourceNotFoundException(404, "getGroup", "group", paymentDto.getGroupId()));
            User user = authRepository.findById(paymentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(404, "getUser", "user", paymentDto.getUserId()));
            for (User user1 : group.getPupil()) {
                if (user1 == user) {
                    PaymentDto build = PaymentDto.builder()
                            .student(paymentDto.getStudent())

                            .build();
                }
            }
            return new ApiResponse<>(" Xatolik", false);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

//    public ApiResponse<?> addPayment(PaymentDto paymentDto) {
//        try {
//            User user = authRepository.findById(paymentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException(404, "user", "id", paymentDto.getUserId()));
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
