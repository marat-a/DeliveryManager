package dev.prom.delivery.dto;

import dev.prom.delivery.enums.ERole;
import dev.prom.delivery.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String phone;

    private Set<Role> roles;
}
