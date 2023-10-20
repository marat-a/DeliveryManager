package dev.prom.delivery.models;

import lombok.Data;

import java.util.List;

//Класс, содержащий покупателей
@Data
public class Customer {
    private Long id;
    private String name;
    private String phone, address;
    private List<Order> orders;
}