package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class News  {
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer photoId;

    @Column(nullable = false)
    private Integer videoId;


}
