package dev.prom.delivery.service;

import dev.prom.delivery.models.Order;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface OrderService {

    void deleteOrder(Long id);

    Order updateOrder(Long id, Order order);

    Order createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();
}
