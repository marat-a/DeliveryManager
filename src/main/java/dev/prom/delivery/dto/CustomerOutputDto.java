package dev.prom.delivery.dto;

import dev.prom.delivery.enums.ERole;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerOutputDto {
    private Long id;
    private String name;

    private String phone;

    private ERole ERole;
    private String address;
}
