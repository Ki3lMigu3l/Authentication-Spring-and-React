package br.dev.ezcoder.auth.controllers;

import br.dev.ezcoder.auth.domain.users.UserModel;
import br.dev.ezcoder.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createNewUser (UserModel userModel) {

    }
}
