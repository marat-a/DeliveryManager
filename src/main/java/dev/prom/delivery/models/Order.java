package dev.prom.delivery.models;

import dev.prom.delivery.enums.PayStatus;
import dev.prom.delivery.enums.ProgressStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "deliveryInfo_id")
    private DeliveryInfo deliveryInfo;

    @ManyToOne(targetEntity = Product.class)
    private List<Product> products;

    private BigDecimal sum;

    private BigDecimal paid;

    @Enumerated
    private PayStatus payStatus;
    @Enumerated
    private ProgressStatus progressStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String commentForManager;

}