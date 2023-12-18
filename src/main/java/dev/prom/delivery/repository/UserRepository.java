package dev.prom.delivery.repository;

import dev.prom.delivery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Boolean existsByPhone(String phone);

    Boolean existsByLogin(String login);
}