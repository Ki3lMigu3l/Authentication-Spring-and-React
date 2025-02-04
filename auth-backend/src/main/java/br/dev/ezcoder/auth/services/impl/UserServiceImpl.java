package br.dev.ezcoder.auth.services.impl;

import br.dev.ezcoder.auth.domain.users.UserModel;
import br.dev.ezcoder.auth.repositories.UserRepository;
import br.dev.ezcoder.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserModel findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findUserbyId(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
