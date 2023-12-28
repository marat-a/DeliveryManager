package dev.prom.delivery.mappers;

import dev.prom.delivery.dto.CustomerDto;
import dev.prom.delivery.dto.CustomerOutputDto;
import dev.prom.delivery.models.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerOutputDto customerToCustomerOutputDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

    List<CustomerOutputDto> customersToCustomerOutputDtos(List<Customer> customers);
}