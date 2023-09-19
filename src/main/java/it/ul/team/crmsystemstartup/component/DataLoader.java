package it.ul.team.crmsystemstartup.component;

import it.ul.team.crmsystemstartup.entity.LidStatus;
import it.ul.team.crmsystemstartup.entity.Role;
import it.ul.team.crmsystemstartup.entity.User;
import it.ul.team.crmsystemstartup.entity.enums.LidStatusName;
import it.ul.team.crmsystemstartup.entity.enums.RoleName;
import it.ul.team.crmsystemstartup.repository.AuthRepository;
import it.ul.team.crmsystemstartup.repository.LidStatusRepository;
import it.ul.team.crmsystemstartup.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String intiMode;

    private final AuthRepository authRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final LidStatusRepository lidStatusRepository;

    @Override
    public void run(String... args) throws Exception {
        if (intiMode.equals("create") || intiMode.equals("create-drop")) {
            for (RoleName value : RoleName.values()) {
                roleRepository.save(new Role(value));
            }
            for (LidStatusName value : LidStatusName.values()) {
                lidStatusRepository.save(new LidStatus(value));
            }
            authRepository.save(
                    User.builder()
                            .firstName("qozi")
                            .lastName("gadayev")
                            .middleName("tvarovich")
                            .phoneNumber("990008877")
                            .password(passwordEncoder.encode("ceo1234"))
                            .prePassword(passwordEncoder.encode("ceo1234"))
                            .roles(Collections.singletonList(roleRepository.findById(1).orElseThrow(() -> new ResourceNotFoundException("getRole"))))
                            .accountNonLocked(true)
                            .accountNonExpired(true)
                            .credentialsNonExpired(true)
                            .enabled(true)
                            .build()
            );
        }
    }
}
