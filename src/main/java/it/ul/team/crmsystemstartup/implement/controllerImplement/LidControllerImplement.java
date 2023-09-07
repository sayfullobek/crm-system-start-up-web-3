package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.UserDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface LidControllerImplement {
    HttpEntity<?> getLid();

    HttpEntity<?> addLid(UserDto userDto);

    HttpEntity<?> editLid(UUID id, UserDto userDto);

    HttpEntity<?> deleteLid(UUID id);

    HttpEntity<?> getOneLid(UUID id);
}
