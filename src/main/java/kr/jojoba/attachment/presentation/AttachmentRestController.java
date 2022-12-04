package kr.jojoba.attachment.presentation;

import kr.jojoba.attachment.application.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AttachmentRestController {

    private final AttachmentService attachmentService;
}
