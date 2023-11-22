package dev.prom.delivery.dto;

import dev.prom.delivery.models.Customer;
import dev.prom.delivery.models.User;

import java.time.LocalDateTime;

public class OrderInputDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String items;
    private User courier;
    private Customer customer;
    private String commentForManager;
    private String commentForMCourier;
}