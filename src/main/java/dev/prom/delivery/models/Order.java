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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryInfo_id")
    private DeliveryInfo deliveryInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
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