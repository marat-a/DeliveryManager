package dev.prom.delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends User {

    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}