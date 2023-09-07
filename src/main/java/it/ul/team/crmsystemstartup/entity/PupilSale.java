package it.ul.team.crmsystemstartup.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PupilSale {
    @Id
    @Column(nullable = false)
    private Integer id;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> pupil;
    @Column(nullable = false)
    private double saleSum;

}
