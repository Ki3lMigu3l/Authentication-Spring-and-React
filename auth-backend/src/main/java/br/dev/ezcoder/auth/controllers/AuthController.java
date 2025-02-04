package br.dev.ezcoder.auth.controllers;

import br.dev.ezcoder.auth.domain.users.UserModel;
import br.dev.ezcoder.auth.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final private AuthenticationManager authenticationManager;
    final private UserService userService;

    public AuthController (AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }


    @PostMapping("/login")
    public void userLogin (@RequestBody UserModel userModel) {

    }

    @PostMapping("/register")
    public ResponseEntity userRegister (@RequestBody UserModel userModel) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(userModel.getPassword());
        UserModel user = new UserModel(userModel.getUsername(), encryptedPassword, userModel.getRoles());

        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
