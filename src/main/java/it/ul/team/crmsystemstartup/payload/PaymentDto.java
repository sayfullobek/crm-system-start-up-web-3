package it.ul.team.crmsystemstartup.payload;

import it.ul.team.crmsystemstartup.entity.PayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private UUID id;
    private String student;
    private List<PayType> payTypes;
    private Double sum;
    private String date;
    private UUID userId;
    private Integer courseId;
    private UUID groupId;
}
