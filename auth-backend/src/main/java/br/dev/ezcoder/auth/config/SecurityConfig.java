package br.dev.ezcoder.auth.config;

import br.dev.ezcoder.auth.security.CustomUserDetailsService;
import br.dev.ezcoder.auth.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/auth/register").permitAll()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService (UserService userService) {
        return new CustomUserDetailsService(userService);
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(10);
    }
}
