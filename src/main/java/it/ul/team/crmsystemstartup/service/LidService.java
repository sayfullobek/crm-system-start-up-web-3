package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Course;
import it.ul.team.crmsystemstartup.entity.LidStatus;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.serviceImplement.LidServiceImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.UserDto;
import it.ul.team.crmsystemstartup.repository.CourseRepository;
import it.ul.team.crmsystemstartup.repository.LidStatusRepository;
import it.ul.team.crmsystemstartup.repository.RoleRepository;
import it.ul.team.crmsystemstartup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LidService implements LidServiceImplement {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final RoleRepository roleRepository;
    private final LidStatusRepository lidStatusRepository;

    @Override
    public List<UserDto> getLid() {
        List<User> all = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : all) {
            userDtoList.add(
                    UserDto.builder()
                            .id(user.getId())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                            .phoneNumber(user.getPhoneNumber())
                            .lidType(user.getLidType())
                            .lidStatus((LidStatus) user.getLidStatuses())
                            .date(user.getDate())
                            .courses(user.getCourses())
                            .build()
            );
        }
        return userDtoList;
    }

    @Override
    public ApiResponse<?> addLid(UserDto userDto) {
        try {
            Course course = courseRepository.findById(userDto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException(404, "getCourse", "getCourseId", userDto.getCourseId()));
            if (course != null) {
                User user = User.builder()
                        .firstName(userDto.getFirstName())
                        .lastName(userDto.getLastName())
                        .phoneNumber(userDto.getPhoneNumber())
                        .courses(Collections.singletonList(course))
                        .date(userDto.getDate())
                        .lidStatuses(Collections.singletonList(lidStatusRepository.findById(userDto.getLidStatusId()).orElseThrow(() -> new ResourceNotFoundException(404, "getLidStatus", "lidStatusId", userDto.getLidStatusId()))))
                        .lidType(userDto.getLidType())
                        .roles(Collections.singletonList(roleRepository.findById(5).orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("getRole"))))
                        .build();
                userRepository.save(user);
                return new ApiResponse<>("Saqlandi", true);
            }
            return new ApiResponse<>("Course mavjud emas", false);
        } catch (Exception e) {
            return new ApiResponse<>("Kichik xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> editLid(UUID id, UserDto userDto) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getUser", "getUserId", id));
            List<Course> courses = new ArrayList<>();
            for (Course cours : userDto.getCourses()) {
                Course course = courseRepository.findById(cours.getId()).orElseThrow(() -> new ResourceNotFoundException(404, "getCourse", "getCourseId", cours.getId()));
                courses.add(course);
            }
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
//            user.setCourses(courses);
            user.setDate(userDto.getDate());
            user.setLidStatuses(Collections.singletonList(lidStatusRepository.findById(userDto.getLidStatusId()).orElseThrow(() -> new ResourceNotFoundException(404, "getLidStatus", "lidStatusId", userDto.getLidStatusId()))));
            user.setLidType(userDto.getLidType());
            user.setRoles(Collections.singletonList(roleRepository.findById(5).orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("getRole"))));
            userRepository.save(user);
            return new ApiResponse<>("Taxrirlandi", true);
        } catch (Exception e) {
            return new ApiResponse<>("Taxrirlashda xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> deleteLid(UUID id) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getUser", "getUserId", id));
            userRepository.delete(user);
            return new ApiResponse<>("Delete", true);
        } catch (Exception e) {
            return new ApiResponse<>("Delete error", false);
        }
    }

    @Override
    public ApiResponse<?> getOneLid(UUID id) {
        return null;
    }
}
