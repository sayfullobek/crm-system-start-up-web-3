package it.ul.team.crmsystemstartup.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    private UUID userId;
    @NotBlank(message = "tel raqam bo'lishi shart")
    private String phoneNumber;
    private String password;
}
