package io.harmony.harmonyservice.repository;

import io.harmony.harmonyservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByKakaoName(String kakaoName);
}
