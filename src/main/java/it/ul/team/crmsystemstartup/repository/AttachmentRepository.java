package it.revo.onlineshopweb3.repository;

import it.revo.onlineshopweb3.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
