package kr.jojoba.talk.application;

import kr.jojoba.talk.infrastructure.TalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TalkService {

    private final TalkRepository talkRepository;
}
