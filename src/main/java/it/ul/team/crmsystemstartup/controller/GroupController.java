package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.GroupControllerImpl;
import it.ul.team.crmsystemstartup.payload.GroupDto;
import org.springframework.http.HttpEntity;

import java.util.UUID;

public class GroupController implements GroupControllerImpl {
    @Override
    public HttpEntity<?> getGroup() {
        return null;
    }

    @Override
    public HttpEntity<?> addGroup(GroupDto groupDto) {
        return null;
    }

    @Override
    public HttpEntity<?> editeGroup(UUID id, GroupDto groupDto) {
        return null;
    }

    @Override
    public HttpEntity<?> deleteGroup(UUID id) {
        return null;
    }
}
