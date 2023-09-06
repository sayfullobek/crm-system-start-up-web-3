package it.ul.team.crmsystemstartup.implement.serviceImplement;

import io.swagger.annotations.Api;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.CourseDto;

import java.util.List;

public interface CourseServiceImpl {
    List<CourseDto> getCourse();
    ApiResponse<?>addCourse(CourseDto courseDto);
    ApiResponse<?>editeCourse(Integer id, CourseDto courseDto);
    ApiResponse<?>deleteCourse(Integer id);
}
