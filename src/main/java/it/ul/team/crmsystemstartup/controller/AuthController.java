package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.RegisterDto;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.payload.LoginDto;
import it.ul.team.crmsystemstartup.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody LoginDto request) {
        return authService.login(request, authenticationManager);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOneUser(@PathVariable UUID id) {
        User user = authRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getUserr"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto registerDto) {
        return authService.register(registerDto, authenticationManager);
    }

    @PostMapping("/tech/{userId}")
    public HttpEntity<?> addTeacher(@PathVariable UUID userId, @RequestBody RegisterDto registerDto) {
        ApiResponse<?> apiResponse = authService.addTeacher(userId, registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/teacher")
    public HttpEntity<?> getTeacher() {
        List<RegisterDto> teacher = authService.getTeacher();
        return ResponseEntity.ok(teacher);
    }

    @PostMapping("/admin/{userId}")
    public HttpEntity<?> addAdmin(@PathVariable UUID userId, @RequestBody RegisterDto registerDto) {
        ApiResponse<?> apiResponse = authService.addAdmin(userId, registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/admin")
    public HttpEntity<?> getAdmin() {
        List<RegisterDto> teacher = authService.getAdmin();
        return ResponseEntity.ok(teacher);
    }
}
