package kr.jojoba.talk.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TalkCustomRepositoryImpl implements TalkCustomRepository {

    private final JPAQueryFactory queryFactory;
}
