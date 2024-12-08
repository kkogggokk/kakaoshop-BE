package com.example.kakao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);   // 반환 타입이 Optional<User>
}

