package dev.prom.delivery.dto;

import dev.prom.delivery.enums.ERole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {

    private Long id;

    private String name;

    private String phone;

    private ERole ERole;

    public UserOutputDto(String name, String phone, dev.prom.delivery.enums.ERole role) {
    }
}