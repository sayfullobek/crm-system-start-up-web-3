package it.revo.onlineshopweb3.service;


import it.revo.onlineshopweb3.entity.Attachment;
import it.revo.onlineshopweb3.entity.AttachmentContent;
import it.revo.onlineshopweb3.repository.AttachmentContentRepository;
import it.revo.onlineshopweb3.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentService {


    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    public UUID upload(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        Attachment attachment = Attachment.builder()
                .name(file.getOriginalFilename())
                .contentType(file.getContentType())
                .size(file.getSize())
                .build();

        Attachment save = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = AttachmentContent.builder()
                .attachment(save)
                .bytes(file.getBytes())
                .build();
        attachmentContentRepository.save(attachmentContent);
         return save.getId();
    }

    public HttpEntity<?> download(UUID id) {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getAttachment"));
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(attachment.getId());
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + attachment.getName() + "\"")
                .body(attachmentContent.getBytes());

    }


}
