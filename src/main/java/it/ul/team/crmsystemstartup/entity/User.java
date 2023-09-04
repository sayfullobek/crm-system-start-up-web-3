package it.ul.team.crmsystemstartup.entity;

import it.ul.team.crmsystemstartup.entity.enums.InComeType;
import it.ul.team.crmsystemstartup.entity.templates.AbsEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Builder
public class User extends AbsEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String date;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_courses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "courses_id")})
    private List<Course> courses;

    @OneToMany
    private Set<Role> roles;

    private boolean isActive;

    @ManyToOne
    private LidStatus lidStatus;

    @ManyToOne
    private LidType lidType;

    @ManyToMany
    private List<Payment> payment;

    @ManyToMany
    private List<Attendance> attendances;

    @Enumerated(value = EnumType.STRING)
    private InComeType inComeType;

    @ManyToOne
    private MonthlyEmployeIncome monthlyEmployeIncome;
}
