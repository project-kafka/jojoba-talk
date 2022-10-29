package kr.jojoba.finance.wallet.domain;

import kr.jojoba.commons.Timestamp;
import kr.jojoba.finance.wallet.constraints.WireState;
import kr.jojoba.finance.wallet.constraints.WireType;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "wire_history")
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@DynamicInsert
public class WireHistory extends Timestamp {

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_wallet_id")
    private Wallet wallet;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bank", column = @Column(name = "bank")),
            @AttributeOverride(name = "accountNumber", column = @Column(name = "account_number")),
            @AttributeOverride(name = "accountHolder", column = @Column(name = "account_holder"))
    })
    private Account account;

    @Column(columnDefinition = "bigint")
    private Long amount;

    @Builder
    public WireHistory(UUID id, WireType wireType, WireState wireState, Wallet wallet, Account account, Long amount) {
        this.id = id;
        this.wireType = wireType;
        this.wireState = wireState;
        this.wallet = wallet;
        this.account = account;
        this.amount = amount;
    }
}
