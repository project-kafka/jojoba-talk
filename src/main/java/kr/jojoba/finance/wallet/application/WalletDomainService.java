package kr.jojoba.finance.wallet.application;

import kr.jojoba.errors.NotFoundException;
import kr.jojoba.finance.wallet.domain.Wallet;
import kr.jojoba.finance.wallet.infrastrucrture.WalletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletDomainService {

    private final WalletRepository walletRepository;

    public void transferMoney(final UUID senderUserId, final UUID receiverUserId, final Long amount) {
        Wallet senderWallet = walletRepository.findOneByUserId(senderUserId)
                .orElseThrow(() -> new NotFoundException("유저 지갑 정보를 찾을 수 없습니다."));

        Wallet receiverWallet = walletRepository.findOneByUserId(receiverUserId)
                .orElseThrow(() -> new NotFoundException("유저 지갑 정보를 찾을 수 없습니다."));

        senderWallet.takeOutMoney(amount);
        receiverWallet.putInMoney(amount);

        log.info("transferMoney(senderUserId: {}, receiverUserId: {}, amount: {})", senderUserId, receiverUserId, amount);
    }
}
