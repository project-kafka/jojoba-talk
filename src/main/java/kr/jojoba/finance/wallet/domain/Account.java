package kr.jojoba.finance.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String bank;
    private String accountNumber;
    private String accountHolder;
}
