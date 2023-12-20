package dev.prom.delivery.enums;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum ERole implements GrantedAuthority {

    ADMIN("ADMIN"),
    MANAGER ("MANAGER"),
    COURIER("COURIER"),
    CUSTOMER("CUSTOMER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }

}
