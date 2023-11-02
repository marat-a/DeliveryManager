package dev.prom.delivery.models;

import lombok.Data;

import java.util.List;

@Data
public class Customer extends User {
    private String address;
    private List<Order> orders;
}