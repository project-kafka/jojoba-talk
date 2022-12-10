package kr.jojoba.finance.wallet.presentation;

import kr.jojoba.finance.wallet.application.WalletService;
import kr.jojoba.finance.wallet.domain.WalletDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.UUID;

import static kr.jojoba.utils.ApiUtil.*;

@RestController
@RequiredArgsConstructor
public class WalletRestController {

    private final WalletService walletService;

    /*
     * 송금 API
     */
    @PostMapping("/v1/banks/{senderUserId}/transfer-money")
    public ApiResult<?> transferMoney(@PathVariable("senderUserId")UUID senderUserId, @RequestBody @Valid WalletDto walletDto) {
        walletService.transferMoney(senderUserId, walletDto);
        return success(null);
    }

    /*
     * 돈 뿌리기 API
     */
    @PostMapping("/v1/banks/{senderUserId}/disperse-money")
    public ApiResult<?> disperseMoney(@PathVariable("senderUserId")UUID senderUserId, @RequestBody @Valid WalletDto walletDto) {
        return success(null);
    }
}
