package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.enums.WeekDaysName;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Week_day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(value = EnumType.STRING)
    private WeekDaysName weekDaysName;

    public Week_day(WeekDaysName weekDaysName) {
        this.weekDaysName = weekDaysName;
    }
}
