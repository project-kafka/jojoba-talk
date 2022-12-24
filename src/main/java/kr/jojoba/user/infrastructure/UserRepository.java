package kr.jojoba.user.infrastructure;

import java.util.Optional;
import java.util.UUID;
import kr.jojoba.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface UserRepository extends JpaRepository<User, String>, RevisionRepository<User, String, Integer>, UserCustomRepository {
    Optional<User> findById(UUID uuid);
}
