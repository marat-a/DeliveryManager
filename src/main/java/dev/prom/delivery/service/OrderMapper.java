package dev.prom.delivery.service;

import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderOutputDto orderToOrderOutputDto(Order order);

    Order orderInputDtoToOrder(OrderInputDto orderDto);

    List<OrderOutputDto> ordersToOrderOutputDtos(List<Order> orders);
}