package kr.jojoba.finance.wallet.domain;

import kr.jojoba.commons.Timestamp;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "wallet")
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Audited
public class Wallet extends Timestamp {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "user_id")
    private Long userId;

    @Column(columnDefinition = "bigint")
    private Long amount;

    @Builder
    public Wallet(UUID id, Long userId, Long amount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
    }

    public void updateAmount(final Long amount) {
        this.amount = amount;
    }
}
