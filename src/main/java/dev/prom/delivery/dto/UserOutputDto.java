package dev.prom.delivery.dto;

import dev.prom.delivery.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {

    private Long id;

    private String name;

    private String phone;

    private ERole ERole;
}