package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Attachment;
import it.ul.team.crmsystemstartup.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    AttachmentContent findByAttachmentId(UUID id);

//    @Query("select attachment from AttachmentContent where attachment.id=?1")
//    Attachment findAttachmentContentByAttachmentId(UUID id);
}
