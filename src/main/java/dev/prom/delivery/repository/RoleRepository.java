package dev.prom.delivery.repository;

import java.util.Optional;

import dev.prom.delivery.enums.ERole;
import dev.prom.delivery.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
