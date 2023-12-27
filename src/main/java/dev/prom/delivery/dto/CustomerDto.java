package dev.prom.delivery.dto;

import dev.prom.delivery.models.Role;

import java.util.Set;

public class CustomerDto {
    private String name;

    private String phone;

    private Set<Role> roles;

    private String address;
}
