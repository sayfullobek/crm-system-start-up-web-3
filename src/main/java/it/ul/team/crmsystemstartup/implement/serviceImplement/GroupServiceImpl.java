package it.ul.team.crmsystemstartup.implement.serviceImplement;

import io.swagger.annotations.Api;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.GroupDto;

import java.util.List;
import java.util.UUID;

public interface GroupServiceImpl {
    List<GroupDto> getGroup();
    ApiResponse<?>addGroup(GroupDto groupDto);
    ApiResponse<?>editeGroup(UUID id,GroupDto groupDto);
    ApiResponse<?>deleteGroup(UUID id);


}
