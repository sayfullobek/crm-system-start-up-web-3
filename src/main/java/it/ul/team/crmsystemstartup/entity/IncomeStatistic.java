package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "income_statistic")
public class IncomeStatistic extends AbsEntity {

    @Column(nullable = false)
    private double allS;

    private double monthly;

    private double allS_cost;

    private double monthly_cost;
    private LocalDate nowDate;
}
