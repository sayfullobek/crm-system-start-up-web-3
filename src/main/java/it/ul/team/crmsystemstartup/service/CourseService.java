package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Attachment;
import it.ul.team.crmsystemstartup.entity.AttachmentContent;
import it.ul.team.crmsystemstartup.entity.Course;
import it.ul.team.crmsystemstartup.entity.Group;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.CourseServiceImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.CourseDto;
import it.ul.team.crmsystemstartup.repository.AttachmentContentRepository;
import it.ul.team.crmsystemstartup.repository.AttachmentRepository;
import it.ul.team.crmsystemstartup.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sun.applet.AppletIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseServiceImpl {
    private final CourseRepository courseRepository;
    private final AttachmentContentRepository attachmentContentRepository;
    private final AttachmentRepository attachmentRepository;


    @Override
    public List<CourseDto> getCourse() {
        List<Course> all = courseRepository.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : all) {
            CourseDto courseDto = CourseDto.builder()
                    .id(course.getId())
                    .name(course.getName())
                    .price(course.getPrice())
                    .expireDate(course.getExpireDate())
                    .description(course.getDescription())
                    .isActive(course.isActive())
                    .photoId(course.getPhotoId())
                    .build();
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }

    @Override
    public ApiResponse<?> addCourse(CourseDto courseDto) {
        try {
            boolean exist = courseRepository.existsCourseByNameEqualsIgnoreCase(courseDto.getName());
            if (!exist) {
                Course course = Course.builder()
                        .price(courseDto.getPrice())
                        .expireDate(courseDto.getExpireDate())
                        .description(courseDto.getDescription())
                        .photoId(courseDto.getPhotoId())
                        .isActive(true)
                        .build();
                course.setName(courseDto.getName());
                courseRepository.save(course);
                return new ApiResponse<>("Course saqlandi", true);
            }
            return new ApiResponse<>("bunday course vamjud emas", false);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> editeCourse(Integer id, CourseDto courseDto) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getCourse", "id", id));
            boolean exist = courseRepository.existsCoursesByNameEqualsIgnoreCaseAndIdNot(courseDto.getName(), id);
            if (!exist) {
                course.setName(courseDto.getName());
                course.setPrice(courseDto.getPrice());
                course.setExpireDate(courseDto.getExpireDate());
                course.setDescription(courseDto.getDescription());
                course.setPhotoId(courseDto.getPhotoId());
                courseRepository.save(course);
                return new ApiResponse<>("course taxrirlandi", true);
            }
            return new ApiResponse<>("bunday course topilmadi", false);
        } catch (Exception e) {
            return new ApiResponse<>("Xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> deleteCourse(Integer id) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getCourse", "id", id));
            courseRepository.delete(course);
            return new ApiResponse<>("course uchirildi", true);
        } catch (Exception e) {
            return new ApiResponse<>("xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> changeActive(Integer id, boolean active) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getActive", "id", id));
            course.setActive(active);
            courseRepository.save(course);
            return new ApiResponse<>("course active o'zgartirildi", true);
        } catch (Exception e) {
            return new ApiResponse<>("Aktive xatolik", false);
        }
    }

    public ApiResponse<?> addPhoto(Integer courseId, UUID photoId) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException(404, "getCourseId", "courseId", courseId));
            if (course.getPhotoId() == null) {
                course.setPhotoId(photoId);
                courseRepository.save(course);
                return new ApiResponse<>("saqlandi", true);
            } else {
                AttachmentContent byAttachmentId = attachmentContentRepository.findByAttachmentId(course.getPhotoId());
                Attachment attachment = attachmentRepository.findById(course.getPhotoId()).orElseThrow(() -> new ResourceNotFoundException(404, "getPhotoId", "photoId", photoId));
                attachmentContentRepository.delete(byAttachmentId);
                attachmentRepository.delete(attachment);
                course.setPhotoId(photoId);
                courseRepository.save(course);
                return new ApiResponse<>("sqalandi", true);
            }
        } catch (Exception e) {

            return new ApiResponse<>("Xatolik", false);
        }
    }



}
