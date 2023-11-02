package dev.prom.delivery.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
//Класс, содержащий заказы

@Data
public class Order {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Product> items;
    private String courier;
    private Customer customer;
    private String comment;
}