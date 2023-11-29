package dev.prom.delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    //    @ManyToOne(targetEntity = Product.class)
//    private List<Product> items;
    private String items;

    private BigDecimal sum;

//    @Enumerated
//    private PayStatus payStatus;
//    @Enumerated
//    private ProgressStatus progressStatus;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private User courier;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String commentForCourier;

    private String commentForManager;

}