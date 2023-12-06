package dev.prom.delivery.models;

import dev.prom.delivery.enums.DeliveryType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class DeliveryInfo {
    private LocalDateTime startTime;

    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private User courier;

    @Enumerated
    DeliveryType deliveryType;

    private String deliveryComment;
}
