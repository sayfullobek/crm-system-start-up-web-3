package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.LidControllerImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.UserDto;
import it.ul.team.crmsystemstartup.service.LidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lids")
@CrossOrigin
public class LidController implements LidControllerImplement {
    private final LidService lidService;

    @Override
    @GetMapping
    public HttpEntity<?> getLid() {
        List<UserDto> lid = lidService.getLid();
        return ResponseEntity.ok(lid);
    }

    @Override
    @PostMapping
    public HttpEntity<?> addLid(@RequestBody UserDto userDto) {
        ApiResponse<?> apiResponse = lidService.addLid(userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @PutMapping("/{id}")
    public HttpEntity<?> editLid(@RequestParam UUID id, @RequestBody UserDto userDto) {
        ApiResponse<?> apiResponse = lidService.editLid(id, userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteLid(@PathVariable UUID id) {
        ApiResponse<?> apiResponse = lidService.deleteLid(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @GetMapping("/{id}")
    public HttpEntity<?> getOneLid(@PathVariable UUID id) {
        ApiResponse<?> oneLid = lidService.getOneLid(id);
        return ResponseEntity.ok(oneLid);
    }
}
