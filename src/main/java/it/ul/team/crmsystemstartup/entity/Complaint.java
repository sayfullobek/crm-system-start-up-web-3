package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.templates.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Complaint extends AbsNameEntity {
    @Column(nullable = false)
    private  Integer id;

    @Column(nullable = false)
    private  String message;

    @Column(nullable = false)
    private Integer userId;
}
