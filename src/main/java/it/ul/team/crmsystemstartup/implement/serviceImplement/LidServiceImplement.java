package it.ul.team.crmsystemstartup.implement.serviceImplement;

import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.UserDto;

import java.util.List;
import java.util.UUID;

public interface LidServiceImplement {
    List<UserDto> getLid();

    ApiResponse<?> addLid(UserDto userDto);

    ApiResponse<?> editLid(UUID id, UserDto userDto);

    ApiResponse<?> deleteLid(UUID id);

    ApiResponse<?> getOneLid(UUID id);
}
