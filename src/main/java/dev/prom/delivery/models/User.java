package dev.prom.delivery.models;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String phone;
    private Role role;
}
