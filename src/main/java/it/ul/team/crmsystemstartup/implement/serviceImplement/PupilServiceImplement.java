package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.UserDto;

import java.util.List;
import java.util.UUID;

public interface PupilServiceImplement {
    List<UserDto> getPupil();

    ApiResponse<?> addPupil(UserDto userDto);

    ApiResponse<?> editPupil(UUID id, UserDto userDto);

    ApiResponse<?> deletePupil(UUID id);

    ApiResponse<?> getOnePupil(UUID id);
}
