package dev.prom.delivery.mappers;

import dev.prom.delivery.dto.CustomerDto;
import dev.prom.delivery.models.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

    List<CustomerDto> customersToCustomerDtos(List<Customer> customers);
}