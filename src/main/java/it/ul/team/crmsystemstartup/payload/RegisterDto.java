package it.ul.team.crmsystemstartup.payload;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDto {
    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
}
