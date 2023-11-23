package dev.prom.delivery.service;

import dev.prom.delivery.exceptions.NotFoundException;
import dev.prom.delivery.models.Order;
import dev.prom.delivery.repository.OrderRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else throw new NotFoundException("Order not found");
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
        } else throw new NotFoundException("Order not found");
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
