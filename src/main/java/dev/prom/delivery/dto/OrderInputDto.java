package dev.prom.delivery.dto;

import dev.prom.delivery.enums.PayStatus;
import dev.prom.delivery.enums.ProgressStatus;
import dev.prom.delivery.models.Customer;
import dev.prom.delivery.models.Product;
import dev.prom.delivery.models.User;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderInputDto {
    private List<Product> products;

    private BigDecimal sum;

    private BigDecimal paid;

    private PayStatus payStatus;
    private ProgressStatus progressStatus;

    private Customer customer;

    private String commentForManager;
}