package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

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
    @OneToMany
    private List<User> teachers;
    @Column(nullable = false)
    private String month;

    private double percent;

    @Column(nullable = false)
    private double allInCome;
}
