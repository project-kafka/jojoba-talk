package kr.jojoba.finance.wallet.infrastrucrture;

import kr.jojoba.finance.wallet.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID>, WalletCustomRepository {

    Optional<Wallet> findOneByUserId(UUID userId);
}
