package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.enums.DayTypeName;
import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "group")
public class Group extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private User teacher;

    @Column(nullable = false)
    private String start_date;

    @Column(nullable = false)
    private String end_date;

    @ManyToMany
    private List<Week_day> weekDays;

    @Enumerated(value = EnumType.STRING)
    private DayTypeName dayTypeName;

    private boolean active = true;

    @ManyToMany
    private List<PupilSale> pupilSales;

    @ManyToMany
    private List<User> pupil;

    @ManyToOne
    private Course course;


}
