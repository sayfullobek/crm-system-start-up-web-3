package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import it.ul.team.crmsystemstartup.entity.PayType;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "payment")
public class Payment extends AbsEntity {

    @Column(nullable = false)
    private String student;
    @ManyToMany
    private List<PayType> payType;
    @Column(nullable = false)
    private Double sum;
    @Column(nullable = false)
    private String date;
    @ManyToMany
    private List<Group> group;


}
