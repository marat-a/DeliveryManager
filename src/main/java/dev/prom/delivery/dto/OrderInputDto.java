package dev.prom.delivery.dto;

import dev.prom.delivery.models.Customer;
import dev.prom.delivery.models.Product;
import dev.prom.delivery.models.User;

import java.time.LocalDateTime;
import java.util.List;

public class OrderInputDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Product> items;
    private User courier;
    private Customer customer;
    private String commentForManager;
    private String commentForMCourier;
}