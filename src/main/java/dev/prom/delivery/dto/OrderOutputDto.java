package dev.prom.delivery.dto;

import dev.prom.delivery.enums.PayStatus;
import dev.prom.delivery.enums.ProgressStatus;
import dev.prom.delivery.models.DeliveryInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderOutputDto {
    private Long id;

    private DeliveryInfo deliveryInfo;

    private List<ProductOutputDto> products;

    private BigDecimal sum;

    private BigDecimal paid;


    private PayStatus payStatus;

    private ProgressStatus progressStatus;


    private CustomerOutputDto customer;

    private String commentForManager;
}