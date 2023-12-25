package dev.prom.delivery.dto;

import dev.prom.delivery.enums.ERole;
import dev.prom.delivery.models.Role;
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

    private Set<Role> roles;

    public UserOutputDto(String name, String phone, dev.prom.delivery.enums.ERole role) {
    }
}