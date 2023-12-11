package dev.prom.delivery.mappers;

import dev.prom.delivery.dto.CustomerOutputDto;
import dev.prom.delivery.dto.OrderInputDto;
import dev.prom.delivery.dto.OrderOutputDto;
import dev.prom.delivery.models.Customer;
import dev.prom.delivery.models.Order;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderOutputDto orderToOrderOutputDto(Order order);

    Order orderInputDtoToOrder(OrderInputDto orderDto);

    List<OrderOutputDto> ordersToOrderOutputDtos(List<Order> orders);

    CustomerOutputDto customerToCustomerOutputDto (Customer customer);
}