package dev.prom.delivery.dto;

import dev.prom.delivery.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerOutputDto {
    private Long id;
    private String name;

    private String phone;

    private Role role;
    private String address;
}
