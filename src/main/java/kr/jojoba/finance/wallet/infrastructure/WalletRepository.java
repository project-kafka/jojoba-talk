package kr.jojoba.finance.wallet.infrastructure;

import kr.jojoba.finance.wallet.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String>, RevisionRepository<Wallet, String, Integer>, kr.jojoba.finance.wallet.infrastructure.WalletCustomRepository {
}
