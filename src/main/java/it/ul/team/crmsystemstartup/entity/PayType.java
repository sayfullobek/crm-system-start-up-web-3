package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.enums.PayTypeName;
import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "pay_type")
public class PayType extends AbsEntity {
    @Enumerated(value = EnumType.STRING)
    private PayTypeName payTypeName;
}
