package kr.jojoba.finance.wallet.application;

import kr.jojoba.finance.wallet.infrastrucrture.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
}
