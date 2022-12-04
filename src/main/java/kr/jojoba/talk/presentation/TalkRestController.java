package kr.jojoba.talk.presentation;

import kr.jojoba.talk.application.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TalkRestController {

    private final TalkService talkService;
}
