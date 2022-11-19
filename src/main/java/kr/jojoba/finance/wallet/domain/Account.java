package kr.jojoba.finance.wallet.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@ToString
public class Account {

    private String bank;
    private String accountNumber;
    private String accountHolder;
}
