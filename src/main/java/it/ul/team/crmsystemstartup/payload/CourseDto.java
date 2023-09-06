package it.ul.team.crmsystemstartup.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
private Integer id;
private String name;
private double price;
private Integer expireDate;
private String description;
private boolean isActive=true;
}
