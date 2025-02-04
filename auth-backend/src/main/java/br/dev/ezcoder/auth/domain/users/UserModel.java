package br.dev.ezcoder.auth.domain.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @Column
    private UserRoles roles;

    public UserModel() {

    }

    public UserModel(String username, String password, UserRoles roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UserRoles getRoles() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
