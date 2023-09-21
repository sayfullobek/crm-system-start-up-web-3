package it.ul.team.crmsystemstartup.payload;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncomeStatisticDto {
    private UUID id;
    private UUID studentId;
    private double allS;
    private double monthly;
    private double allS_cost;
    private double monthly_cost;
}
