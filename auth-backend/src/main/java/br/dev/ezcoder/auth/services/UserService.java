package br.dev.ezcoder.auth.services;

import br.dev.ezcoder.auth.domain.users.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserModel findUserByUsername(String username);

    UserModel save(UserModel userModel);

    List<UserModel> findAll();

    Optional<UserModel> findUserbyId(UUID id);

    void delete(UserModel userModel);
}
