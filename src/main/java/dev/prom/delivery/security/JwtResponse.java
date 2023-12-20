package dev.prom.delivery.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String login;
    private String phone;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String login, String phone, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.login = login;
        this.phone = phone;
        this.roles = roles;
    }
}