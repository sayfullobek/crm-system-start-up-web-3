package it.ul.team.crmsystemstartup.payload;

import it.ul.team.crmsystemstartup.entity.Course;
import it.ul.team.crmsystemstartup.entity.PupilSale;
import it.ul.team.crmsystemstartup.entity.User;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDto {
    private UUID id;
    private Integer courseId;
    private String name;
    private UUID teacherId;
    private List<User> pupil;
    private String start_date;
    private String end_date;
    private List<SelectDto> weekDays;
    private Integer dayTypeName;
    private boolean isActive;
    private UUID photoId;
    private Course course;


}
