package kr.jojoba.attachment.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AttachmentCustomRepositoryImpl implements AttachmentCustomRepository {

    private final JPAQueryFactory queryFactory;
}
