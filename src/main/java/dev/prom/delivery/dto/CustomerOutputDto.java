package dev.prom.delivery.dto;

import dev.prom.delivery.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class CustomerOutputDto {
    private Long id;
    private String name;

    private String phone;

    private Set<Role> roles;
    private String address;
}
