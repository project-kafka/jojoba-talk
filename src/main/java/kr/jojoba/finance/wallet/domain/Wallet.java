package kr.jojoba.finance.wallet.domain;

import kr.jojoba.commons.BaseTimeStamp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "wallet")
@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wallet extends BaseTimeStamp {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "user_id", unique = true, nullable = false, updatable = false)
    private UUID userId;

    @Column(columnDefinition = "bigint")
    private Long amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet)) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void takeOutMoney(Long amount) {
        if (amount > this.amount) {
            throw new IllegalArgumentException("금액이 충분치 않습니다.");
        }

        this.amount -= amount;
    }

    public void putInMoney(Long amount) {
        this.amount += amount;
    }
}
