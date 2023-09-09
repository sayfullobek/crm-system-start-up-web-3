package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.CourseDto;
import org.springframework.http.HttpEntity;

public interface CourseControllerImpl {
    HttpEntity<?>getCourse();
    HttpEntity<?>addCourse(CourseDto courseDto);
    HttpEntity<?> editeCourse(Integer id,CourseDto courseDto);
    HttpEntity<?> deleteCourse(Integer id);
    HttpEntity<?>getOneCourse(Integer id);
}
