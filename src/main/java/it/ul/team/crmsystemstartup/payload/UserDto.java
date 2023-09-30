package it.ul.team.crmsystemstartup.payload;

import it.ul.team.crmsystemstartup.entity.*;
import it.ul.team.crmsystemstartup.entity.enums.InComeType;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private UUID id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String phoneNumber;

    private String password;

    private String date;

    private List<Course> courses;

    private Integer courseId;

    private List<Role> roles;

    private boolean isActive;

    private LidStatus lidStatus;

    private Integer lidStatusId;

    private Integer lidTypeId;

    private LidType lidType;

    private String lidTypeName;

    private List<Payment> payment;

    private List<Attendance> attendances;

    private InComeType inComeType;

    private MonthlyEmployerIncome monthlyEmployeIncome;
}
