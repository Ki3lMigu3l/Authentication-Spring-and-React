package br.dev.ezcoder.auth.security;

import br.dev.ezcoder.auth.domain.users.UserModel;
import br.dev.ezcoder.auth.services.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService (UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userService.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
