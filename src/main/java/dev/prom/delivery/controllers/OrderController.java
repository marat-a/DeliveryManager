package dev.prom.delivery.controllers;


import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.mappers.OrderMapper;
import dev.prom.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@ResponseBody
@CrossOrigin
class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public OrderMapper mapper;


    @GetMapping
    public List<OrderOutputDto> getAllOrders() {
        return mapper.ordersToOrderOutputDtos(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public OrderOutputDto getOrderById(@PathVariable Long id) {
        return mapper.orderToOrderOutputDto(orderService.getOrderById(id));
    }

    @PostMapping
    public OrderOutputDto createOrder(@RequestBody OrderInputDto order) {
        return mapper.orderToOrderOutputDto(orderService.createOrder(mapper.orderInputDtoToOrder(order)));
    }

    @PutMapping("/{id}")
    public OrderOutputDto updateOrder(@PathVariable Long id, @RequestBody OrderInputDto order) {
        return mapper.orderToOrderOutputDto(orderService.updateOrder(id, mapper.orderInputDtoToOrder(order)));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
