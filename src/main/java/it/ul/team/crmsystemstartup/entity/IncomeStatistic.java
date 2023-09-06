package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "income_statistic")
public class IncomeStatistic extends AbsEntity {
    @Column(nullable = false)
    private double allS;

    @Column(nullable = false)
    private double monthly;

    @Column(nullable = false)
    private double allS_cost;

    @Column(nullable = false)
    private double monthly_cost;
}
