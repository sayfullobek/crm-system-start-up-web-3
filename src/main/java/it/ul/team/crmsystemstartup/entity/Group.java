package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.enums.RoleName;
import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Group")
public class Group extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Course course;


}
