package it.ul.team.crmsystemstartup.implement.controllerImplement;

import it.ul.team.crmsystemstartup.payload.GroupDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public interface GroupControllerImpl {
    HttpEntity<?>getGroup();
    HttpEntity<?>addGroup(GroupDto groupDto);
    HttpEntity<?>editeGroup(UUID id,GroupDto groupDto);
    HttpEntity<?>deleteGroup(UUID id);
    HttpEntity<?>changeActive(UUID id,boolean active);
}
