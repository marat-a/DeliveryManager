package dev.prom.delivery.controllers;


import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.enums.ProgressStatus;
import dev.prom.delivery.mappers.OrderMapper;
import dev.prom.delivery.service.OrderService;
import dev.prom.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@ResponseBody
class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public UserService userService;
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

    @GetMapping("/courier/{id}")
    public List<OrderOutputDto> getOrdersByCourier(Authentication authentication) {
        Long courierId = getId(authentication);
        return mapper.ordersToOrderOutputDtos(orderService.getOrdersByCourier(courierId));
    }

    @PutMapping("/status/{id}")
    public OrderOutputDto changeStatus(@PathVariable Long id, @RequestBody ProgressStatus status, Authentication authentication) {
        Long courierId = getId(authentication);
        return mapper.orderToOrderOutputDto(orderService.changeStatus(id, status, courierId));
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

    private Long getId(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = userService.getByLogin(userDetails.getUsername()).get().getId();
        return userId;
    }
}
