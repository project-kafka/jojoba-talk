package kr.jojoba.finance.wallet.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Account {

    private String bank;
    private String accountNumber;
    private String accountHolder;

    @Builder
    public Account(String bank, String accountNumber, String accountHolder) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
}
