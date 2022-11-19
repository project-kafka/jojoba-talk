package kr.jojoba.talk.infrastructure;

import kr.jojoba.talk.domain.TalkMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface TalkRepository extends JpaRepository<TalkMessage, String>, RevisionRepository<TalkMessage, String, Integer>, TalkCustomRepository {
}
