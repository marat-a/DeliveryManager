package dev.prom.delivery.service;

import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface OrderService {

    void deleteOrder(Long id);

    OrderOutputDto updateOrder(Long id, OrderInputDto order);

    OrderOutputDto createOrder(OrderInputDto order);

    OrderOutputDto getOrderById(Long id);

    List<OrderOutputDto> getAllOrders();
}
