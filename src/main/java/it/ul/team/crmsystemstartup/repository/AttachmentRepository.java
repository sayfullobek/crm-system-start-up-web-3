package it.ul.team.crmsystemstartup.repository;

import it.ul.team.crmsystemstartup.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
