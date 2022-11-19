package kr.jojoba.finance.wallet.presentation;

import kr.jojoba.finance.wallet.application.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WalletRestController {

    private final WalletService walletService;
}
