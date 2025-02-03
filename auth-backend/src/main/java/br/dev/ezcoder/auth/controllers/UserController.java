package br.dev.ezcoder.auth.controllers;

import br.dev.ezcoder.auth.domain.users.UserModel;
import br.dev.ezcoder.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> createNewUser(@RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> obtainAllUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtainUserById (@PathVariable UUID id) {
        Optional<UserModel> userOptional = userService.findUserbyId(id);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not exist or User not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById (@PathVariable UUID id) {
        Optional<UserModel> userOptional = userService.findUserbyId(id);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not exist or User not found!");
        }

        userService.delete(userOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted!");
    }
}
