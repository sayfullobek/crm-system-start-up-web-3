package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class MonthlyEmployerIncome extends AbsEntity {

    @Column(nullable = false)
    private double sum;

    @Column(nullable = false)
    private String month;

    private double percent;

    @Column(nullable = false)
    private String allInCome;
}
