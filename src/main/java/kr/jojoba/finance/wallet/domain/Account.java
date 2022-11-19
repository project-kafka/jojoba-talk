package kr.jojoba.finance.wallet.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@Builder
@ToString
@NoArgsConstructor
public class Account {

    private String bank;
    private String accountNumber;
    private String accountHolder;
}
