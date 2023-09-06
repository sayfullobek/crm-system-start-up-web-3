package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {
boolean existsCourseByNameEqualsIgnoreCase(String name);

boolean existsCoursesByNameEqualsIgnoreCaseAndIdNot(String name, Integer id);
//    @Query("select c from course c where c.id=?1")
//    Course getCourse(Integer id);
}
