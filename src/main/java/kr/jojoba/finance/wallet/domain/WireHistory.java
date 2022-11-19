package kr.jojoba.finance.wallet.domain;

import kr.jojoba.commons.BaseTimeStamp;
import kr.jojoba.finance.wallet.constraints.WireState;
import kr.jojoba.finance.wallet.constraints.WireType;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "wire_history")
@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
public class WireHistory extends BaseTimeStamp {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "wire_type")
    @Enumerated(EnumType.STRING)
    private WireType wireType;

    @Column(name = "wire_state")
    @Enumerated(EnumType.STRING)
    private WireState wireState;

    @Column(name = "sender_wallet_id")
    private Long senderWalletId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bank", column = @Column(name = "bank")),
            @AttributeOverride(name = "accountNumber", column = @Column(name = "account_number")),
            @AttributeOverride(name = "accountHolder", column = @Column(name = "account_holder"))
    })
    private Account account;

    @Column(columnDefinition = "bigint")
    private Long amount;

    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return super.getUpdatedAt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WireHistory)) return false;
        WireHistory that = (WireHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
