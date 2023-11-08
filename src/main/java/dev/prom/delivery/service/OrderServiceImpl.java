package dev.prom.delivery.service;

import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderOutputDto updateOrder(Long id, OrderInputDto order) {
        return null;
    }

    @Override
    public OrderOutputDto createOrder(OrderInputDto order) {
        return null;
    }

    @Override
    public OrderOutputDto getOrderById(Long id) {
        //обработать Optoinal на null
        return OrderMapper.INSTANCE.orderToOrderOutputDto(orderRepository.findById(id).get());
    }

    @Override
    public List<OrderOutputDto> getAllOrders() {
        return OrderMapper.INSTANCE.ordersToOrderOutputDtos(orderRepository.findAll());
    }
}
