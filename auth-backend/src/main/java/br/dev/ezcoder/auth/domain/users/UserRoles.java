package br.dev.ezcoder.auth.domain.users;

public enum UserRoles {
    USER_ROLES("user"),
    ADMIN_ROLES("admin");

    private String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
