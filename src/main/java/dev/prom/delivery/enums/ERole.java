package dev.prom.delivery.enums;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum ERole implements GrantedAuthority {

    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    COURIER("ROLE_COURIER"),
    CUSTOMER("ROLE_CUSTOMER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }

}
