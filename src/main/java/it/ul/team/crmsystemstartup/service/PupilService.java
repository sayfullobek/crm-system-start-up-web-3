package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.implement.serviceImplement.PupilServiceImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.UserDto;
import it.ul.team.crmsystemstartup.repository.RoleRepository;
import it.ul.team.crmsystemstartup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PupilService implements PupilServiceImplement {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<UserDto> getPupil() {
        List<User> all = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : all) {
            userDtoList.add(
                    UserDto.builder()
                            .id(user.getId())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                            .middleName(user.getMiddleName())
                            .phoneNumber(user.getPhoneNumber())
                            .courses(user.getCourses())
                            .lidStatus(user.getLidStatus())
                            .roles(user.getRoles())
                            .date(user.getDate())
                            .payment(user.getPayment())
                            .isActive(true)
                            .build()
            );
        }
        return userDtoList;
    }

    @Override
    public ApiResponse<?> addPupil(UserDto userDto) {
        try {
            User build = User.builder()
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .middleName(userDto.getMiddleName())
                    .date(userDto.getDate())
                    .phoneNumber(userDto.getPhoneNumber())
                    .courses(userDto.getCourses())
                    .roles(Collections.singleton(roleRepository.findById(5).orElseThrow(() -> new ResourceNotFoundException("getRole"))))
                    .password(userDto.getPassword())
                    .isActive(true)
                    .build();
            userRepository.save(build);
            return new ApiResponse<>("Saqlandi", true);
        } catch (Exception e) {
            return new ApiResponse<>("Xatolik", true);
        }
    }

    @Override
    public ApiResponse<?> editPupil(UUID id, UserDto userDto) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "getUser", "getUserId", id));
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setMiddleName(user.getMiddleName());
            user.setDate(userDto.getDate());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCourses(userDto.getCourses());
            user.setRoles(Collections.singleton(roleRepository.findById(5).orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("getRole"))));
            user.setPassword(userDto.getPassword());
            user.setActive(true);
            userRepository.save(user);
            return new ApiResponse<>("Taxrirlandi", true);
        } catch (Exception e) {
            return new ApiResponse<>("Edit err", false);
        }
    }

    @Override
    public ApiResponse<?> deletePupil(UUID id) {
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "getUser", "getUserId", id));
            userRepository.delete(user);
            return new ApiResponse<>("delete", true);
        } catch (Exception e) {
            return new ApiResponse<>("Xatolik", false);
        }
    }

    @Override
    public ApiResponse<?> getOnePupil(UUID id) {
        return null;
    }
}
