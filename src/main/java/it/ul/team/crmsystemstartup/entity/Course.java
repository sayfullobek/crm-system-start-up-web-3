package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsNameEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "courses")
@Builder
public class Course extends AbsNameEntity {

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Integer expireDate;

    @Column(nullable = false)
    private String description;

    private UUID photoId;
//    private boolean isActive=true;

}
