package it.ul.team.crmsystemstartup.controller;

import it.ul.team.crmsystemstartup.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/attachment")
@RequiredArgsConstructor
@CrossOrigin
public class AttachmentController {


    private final AttachmentService attachmentService;

    @PostMapping("/upload")
    public HttpEntity<?> upload(MultipartHttpServletRequest request) throws IOException {
        UUID upload = attachmentService.upload(request);
        return ResponseEntity.ok(upload);
    }

    @GetMapping("/download")
    public HttpEntity<?> download(@RequestParam(value = "id", required = false) UUID id) {
        return attachmentService.download(id);
    }
}

