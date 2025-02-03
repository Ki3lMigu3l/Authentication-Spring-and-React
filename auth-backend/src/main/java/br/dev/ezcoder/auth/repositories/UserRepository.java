package br.dev.ezcoder.auth.repositories;

import br.dev.ezcoder.auth.domain.users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
}
