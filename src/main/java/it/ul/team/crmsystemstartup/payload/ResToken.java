package it.ul.team.crmsystemstartup.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResToken {
    private final String tokenType = "Bearer ";
    private String body;
}
