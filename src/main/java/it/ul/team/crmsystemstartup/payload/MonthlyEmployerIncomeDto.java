package it.ul.team.crmsystemstartup.payload;

import lombok.*;

import javax.persistence.Column;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonthlyEmployerIncomeDto {
    private UUID id;
    private UUID teacherId;
    private double sum;
    private String month;
    private double percent;
    private String allInCome;
}
