package dev.prom.delivery.service;

import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.models.Order;
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
        Order editedOrder = OrderMapper.INSTANCE.orderInputDtoToOrder(order);
        editedOrder.setId(id);
        Order updatedOrder = orderRepository.saveAndFlush(editedOrder);
        return OrderMapper.INSTANCE.orderToOrderOutputDto(updatedOrder);
    }

    @Override
    public OrderOutputDto createOrder(OrderInputDto order) {
        Order newOrder = OrderMapper.INSTANCE.orderInputDtoToOrder(order);
        newOrder = orderRepository.saveAndFlush(newOrder);
        return OrderMapper.INSTANCE.orderToOrderOutputDto(newOrder);
    }

    @Override
    public OrderOutputDto getOrderById(Long id) {
        //обработать Optoinal на null
        return OrderMapper.INSTANCE.orderToOrderOutputDto(orderRepository.findById(id).get());
    }

    @Override
    public List<OrderOutputDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return OrderMapper.INSTANCE.ordersToOrderOutputDtos(orderList);
    }
}
