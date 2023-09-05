package it.ul.team.crmsystemstartup.payload;

import it.ul.team.crmsystemstartup.entity.PayType;

import java.util.List;
import java.util.UUID;

public class PaymentDto {
    private UUID id;
    private String student;
    private List<PayType> payTypes;
    private String sum;
    private String date;
}
