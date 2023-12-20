package dev.prom.delivery.security;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String login;

    @NotBlank
    @Size(max = 50)
    @Email
    private String phone;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


}