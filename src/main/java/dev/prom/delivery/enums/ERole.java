package dev.prom.delivery.enums;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum ERole implements GrantedAuthority {

    ADMIN("ADMIN"),
    MANAGER ("MANAGER"),

    USER("USER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }

}
