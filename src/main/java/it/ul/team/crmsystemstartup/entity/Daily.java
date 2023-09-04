package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsNameEntity;
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
public class Daily extends AbsNameEntity {
    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String hours;

    private boolean isCame;

    @Column(nullable = false)
    private Integer readingPercentage;
}
