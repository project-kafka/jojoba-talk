package kr.jojoba.finance.wallet.application;

import kr.jojoba.finance.wallet.domain.WalletDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletDomainService walletDomainService;

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Transactional
    public void transferMoney(final UUID senderUserId, final WalletDto walletDto) {
        walletDomainService.transferMoney(senderUserId, walletDto.getReceiverUserId(), walletDto.getAmount());
    }
}
