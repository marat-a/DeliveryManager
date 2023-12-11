package dev.prom.delivery.models;

import dev.prom.delivery.enums.DeliveryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "deliveryInfo")
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private User courier;

    @Enumerated
    DeliveryType deliveryType;

    private String deliveryComment;
}
