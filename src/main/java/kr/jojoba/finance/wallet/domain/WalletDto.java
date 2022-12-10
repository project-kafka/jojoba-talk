package kr.jojoba.finance.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {

    @NotNull(message = "receiverUserId must be provided")
    private UUID receiverUserId;
    @NotNull(message = "amount must be provided") @Min(message = "amount must be at least 1", value = 1) @Max(message = "amount is too high", value = Long.MAX_VALUE)
    private Long amount;

}
