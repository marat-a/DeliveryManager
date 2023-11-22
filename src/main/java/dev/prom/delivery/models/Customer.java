package dev.prom.delivery.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @OneToMany
    private List<Order> orders;

}