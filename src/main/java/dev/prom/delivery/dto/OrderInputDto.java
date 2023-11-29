package dev.prom.delivery.dto;

import dev.prom.delivery.models.Customer;
import dev.prom.delivery.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class OrderInputDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String items;
    private User courier;
    private Customer customer;
    private String commentForManager;
    private String commentForMCourier;
}