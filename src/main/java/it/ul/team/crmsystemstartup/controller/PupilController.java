package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.implement.controllerImplement.PupilControllerImplement;
import it.ul.team.crmsystemstartup.payload.ApiResponse;
import it.ul.team.crmsystemstartup.payload.UserDto;
import it.ul.team.crmsystemstartup.service.PupilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/pupil")
@RequiredArgsConstructor
public class PupilController implements PupilControllerImplement {
    private final PupilService pupilService;

    @Override
    @GetMapping
    public HttpEntity<?> getPupil() {
        List<UserDto> lid = pupilService.getPupil();
        return ResponseEntity.ok(lid);
    }

    @Override
    @PostMapping
    public HttpEntity<?> addPupil(@RequestBody UserDto userDto) {
        ApiResponse<?> apiResponse = pupilService.addPupil(userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @PutMapping("/{id}")
    public HttpEntity<?> editPupil(@RequestParam UUID id, @RequestBody UserDto userDto) {
        ApiResponse<?> apiResponse = pupilService.editPupil(id, userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePupil(@PathVariable UUID id) {
        ApiResponse<?> apiResponse = pupilService.deletePupil(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    @Override
    @GetMapping("/{id}")
    public HttpEntity<?> getOnePupil(@PathVariable UUID id) {
        ApiResponse<?> onePupil = pupilService.getOnePupil(id);
        return ResponseEntity.ok(onePupil);
    }
}
