package dev.prom.delivery.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    @Enumerated
    private Role role;

}
