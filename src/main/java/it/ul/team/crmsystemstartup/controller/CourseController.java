package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.CourseControllerImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.CourseDto;
import it.ul.team.crmsystemstartup.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController implements CourseControllerImpl {
    private final CourseService courseService;

    @Override
    @GetMapping
    public HttpEntity<?> getCourse() {
        List<CourseDto> courseDtoList = courseService.getCourse();
        return ResponseEntity.ok(courseDtoList);

    }

    @Override
    @PostMapping
    public HttpEntity<?> addCourse(@RequestBody CourseDto courseDto) {
        ApiResponse<?> apiResponse = courseService.addCourse(courseDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @Override
    @PutMapping("/{id}")
    public HttpEntity<?> editeCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {
        ApiResponse<?> apiResponse = courseService.editeCourse(id, courseDto);
       return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCourse(@PathVariable Integer id) {
        ApiResponse<?> apiResponse = courseService.deleteCourse(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
