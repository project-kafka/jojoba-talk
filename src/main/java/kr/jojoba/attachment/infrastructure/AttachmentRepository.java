package kr.jojoba.attachment.infrastructure;

import kr.jojoba.attachment.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String>, RevisionRepository<Attachment, String, Integer>, AttachmentCustomRepository {
}
