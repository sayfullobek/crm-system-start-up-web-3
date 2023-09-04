package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class News extends AbsEntity {
    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer photoId;

    @Column(nullable = false)
    private Integer videoId;


}
