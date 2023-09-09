package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.entity.Group;
import it.ul.team.crmsystemstartup.exception.ResourceNotFoundException;
import it.ul.team.crmsystemstartup.implement.controllerImplement.GroupControllerImpl;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.GroupDto;
import it.ul.team.crmsystemstartup.repository.GroupRepository;
import it.ul.team.crmsystemstartup.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController implements GroupControllerImpl {
    public final GroupService groupService;
    public final GroupRepository groupRepository;

    @Override
    @GetMapping("/{id}")
    public HttpEntity<?> getOneGroup(@PathVariable UUID id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(404, "getGroup", "groupId", id));
        return ResponseEntity.ok(group);
    }

    @Override
    @GetMapping("/list")
    public HttpEntity<?> getGroup() {
        List<GroupDto> group = groupService.getGroup();
        return ResponseEntity.ok(group);
    }

    @PostMapping
    @Override
    public HttpEntity<?> addGroup(@RequestBody GroupDto groupDto) {
        ApiResponse<?> apiResponse = groupService.addGroup(groupDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/photo")
    public HttpEntity<?> addPhoto(@PathVariable UUID groupId, UUID photoId) {
        ApiResponse<?> apiResponse = groupService.addPhoto(groupId, photoId);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);

    }

    @Override
    @PutMapping("/{id}")
    public HttpEntity<?> editeGroup(UUID id, GroupDto groupDto) {
        ApiResponse<?> apiResponse = groupService.editeGroup(id, groupDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteGroup(UUID id) {
        ApiResponse<?> apiResponse = groupService.deleteGroup(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @Override
    @PutMapping("/active/{id}")
    public HttpEntity<?> changeActive(UUID id, @RequestParam(name = "active") boolean active) {
        ApiResponse<?> apiResponse = groupService.changeActive(id, active);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
