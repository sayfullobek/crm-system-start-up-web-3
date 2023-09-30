package it.ul.team.crmsystemstartup.service;

import it.ul.team.crmsystemstartup.entity.Role;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.payload.*;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.repository.RoleRepository;
import it.ul.team.crmsystemstartup.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class
AuthService implements UserDetailsService {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthRepository authRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return (UserDetails) authRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));
    }

    public UserDetails getUserById(UUID id) {
        return (UserDetails) authRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getUser"));
    }

    public HttpEntity<?> login(LoginDto request, AuthenticationManager authenticationManager) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword())
        );
        User user = authRepository.findUserByPhoneNumber(request.getPhoneNumber()).orElseThrow(() -> new ResourceNotFoundException("getUser"));
        ResToken resToken = new ResToken(generateToken(request.getPhoneNumber()));
        System.out.println(ResponseEntity.ok(getMal(user, resToken)));
        return ResponseEntity.ok(getMal(user, resToken));
    }

    public GetData getMal(User user, ResToken resToken) {
        return new GetData(user, resToken);
    }

    private String generateToken(String phoneNumber) {
        User user = authRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));
        return jwtTokenProvider.generateToken(user.getId());
    }

    public HttpEntity<?> register(RegisterDto registerDto, AuthenticationManager authenticationManager) {
        if (registerDto.getPhoneNumber().length() != 9) {
            return ResponseEntity.ok(new ApiResponse<>("telefon raqamda xatolik", false));
        }
        try {
            User user = User.builder()
                    .firstName(registerDto.getName())
                    .lastName(registerDto.getSurname())
                    .phoneNumber(registerDto.getPhoneNumber())
                    .password(passwordEncoder().encode(registerDto.getPassword()))
                    .roles(Collections.singletonList(roleRepository.findById(4).orElseThrow(() -> new ResourceNotFoundException("getRole"))))
                    .accountNonLocked(true)
                    .accountNonExpired(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();
            User save = authRepository.save(user);
            LoginDto loginDto = LoginDto.builder()
                    .phoneNumber(save.getPhoneNumber())
                    .password(registerDto.getPassword())
                    .build();
            return login(loginDto, authenticationManager);
        } catch (NumberFormatException e) {
            return ResponseEntity.ok(new ApiResponse<>("Telefon raqam faqat raqamdan iborat bo'lishi kerakk", false));
        }
    }

    public List<RegisterDto> getTeacher() {
        Role role1 = roleRepository.findById(4).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "role", "id", 4));
        List<User> all = authRepository.findAll();
        List<RegisterDto> registerDtoList = new ArrayList<>();
        for (User user : all) {
            for (Role role : user.getRoles()) {
                if (role.equals(role1)){
                    registerDtoList.add(
                            RegisterDto.builder()
                                    .name(user.getFirstName())
                                    .surname(user.getLastName())
                                    .phoneNumber(user.getPhoneNumber())
                                    .password(user.getPassword())
                                    .prePassword(user.getPrePassword())
                                    .build()
                    );
                }
            }
        }
        return registerDtoList;
    }

    public ApiResponse<?> addTeacher(UUID userId, RegisterDto registerDto) {
        try {
            User user = authRepository.findById(userId).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "user", "id", userId));
            Role role1 = roleRepository.findById(1).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "role", "id", userId));
            Role teacherRole = roleRepository.findById(4).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "role", "id", userId));
            for (Role role : user.getRoles()) {
                if (role.equals(role1)) {
                    User build = User.builder()
                            .firstName(registerDto.getName())
                            .lastName(registerDto.getSurname())
                            .phoneNumber(registerDto.getPhoneNumber())
                            .password(registerDto.getPassword())
                            .prePassword(registerDto.getPrePassword())
                            .roles(Collections.singletonList(teacherRole))
                            .build();
                    authRepository.save(build);
                    return new ApiResponse<>("O'qituvchi qo'shildi", true);
                }
                return new ApiResponse<>("Faqat director bajara oladi", false);
            }
            return new ApiResponse<>("Xatolik", false);
        } catch (Exception e) {
            return new ApiResponse<>("Xatolik", false);
        }
    }

    public List<RegisterDto> getAdmin() {
        Role role1 = roleRepository.findById(3).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "role", "id", 3));
        List<User> all = authRepository.findAll();
        List<RegisterDto> registerDtoList = new ArrayList<>();
        for (User user : all) {
            for (Role role : user.getRoles()) {
                if (role.equals(role1)){
                    registerDtoList.add(
                            RegisterDto.builder()
                                    .name(user.getFirstName())
                                    .surname(user.getLastName())
                                    .phoneNumber(user.getPhoneNumber())
                                    .password(user.getPassword())
                                    .prePassword(user.getPrePassword())
                                    .build()
                    );
                }
            }
        }
        return registerDtoList;
    }


    public ApiResponse<?> addAdmin(UUID userId, RegisterDto registerDto) {
        try {
            User user = authRepository.findById(userId).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "user", "id", userId));
            Role role1 = roleRepository.findById(1).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "role", "id", userId));
            Role adminRole = roleRepository.findById(3).orElseThrow(() -> new it.ul.team.crmsystemstartup.exception.ResourceNotFoundException(404, "role", "id", userId));
            for (Role role : user.getRoles()) {
                if (role.equals(role1)) {
                    User build = User.builder()
                            .firstName(registerDto.getName())
                            .lastName(registerDto.getSurname())
                            .phoneNumber(registerDto.getPhoneNumber())
                            .password(registerDto.getPassword())
                            .prePassword(registerDto.getPrePassword())
                            .roles(Collections.singletonList(adminRole))
                            .build();
                    authRepository.save(build);
                    return new ApiResponse<>("Admin qo'shildi", true);
                }
                return new ApiResponse<>("Faqat director bajara oladi", false);
            }
            return new ApiResponse<>("Xatolik", false);
        } catch (Exception e) {
            return new ApiResponse<>("Xatolik", false);
        }
    }



}
