package dev.prom.delivery.controllers;


import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderOutputDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderOutputDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public OrderOutputDto createOrder(@RequestBody OrderInputDto order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public OrderOutputDto updateOrder(@PathVariable Long id, @RequestBody OrderInputDto order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
