package dev.prom.delivery.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
//Класс, содержащий позиции товаров
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}