package com.ies_juan_bosco.formulario_fisica.repositorio;

import com.ies_juan_bosco.formulario_fisica.modelo.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
