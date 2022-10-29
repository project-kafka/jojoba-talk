package kr.jojoba.finance.wallet.infrastrucrture;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WalletCustomRepositoryImpl implements WalletCustomRepository {

    private final JPAQueryFactory queryFactory;
}
