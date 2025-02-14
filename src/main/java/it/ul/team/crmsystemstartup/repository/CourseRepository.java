package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    boolean existsCourseByNameEqualsIgnoreCase(String name);
     boolean existsCoursesByNameEqualsIgnoreCaseAndIdNot(String name ,Integer id);

}
