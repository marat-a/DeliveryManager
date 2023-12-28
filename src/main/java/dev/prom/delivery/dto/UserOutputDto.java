package dev.prom.delivery.dto;

import dev.prom.delivery.enums.ERole;
import dev.prom.delivery.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {

    private Long id;

    private String name;

    private String phone;

    private String password;

    private Set<Role> roles;

    private String login;


}