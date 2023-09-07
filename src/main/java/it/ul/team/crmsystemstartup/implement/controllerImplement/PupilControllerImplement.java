package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.UserDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface PupilControllerImplement {
    HttpEntity<?> getPupil();

    HttpEntity<?> addPupil(UserDto userDto);

    HttpEntity<?> editPupil(UUID id, UserDto userDto);

    HttpEntity<?> deletePupil(UUID id);

    HttpEntity<?> getOnePupil(UUID id);
}
