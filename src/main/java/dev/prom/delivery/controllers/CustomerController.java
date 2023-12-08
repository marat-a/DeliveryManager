package dev.prom.delivery.controllers;


import dev.prom.delivery.dto.CustomerDto;
import dev.prom.delivery.dto.CustomerOutputDto;
import dev.prom.delivery.mappers.CustomerMapper;
import dev.prom.delivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@ResponseBody
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper mapper;

    @GetMapping
    public List<CustomerOutputDto> getAllCustomers() {
        return mapper.customersToCustomerOutputDtos(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public CustomerOutputDto getCustomerById(@PathVariable Long id) {
        return mapper.customerToCustomerOutputDto(customerService.getCustomerById(id));
    }

    @PostMapping
    public CustomerOutputDto createCustomer(@RequestBody CustomerDto customerDto) {
        return mapper.customerToCustomerOutputDto(customerService.createCustomer(mapper.customerDtoToCustomer(customerDto)));
    }

    @PutMapping("/{id}")
    public CustomerOutputDto updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        return mapper.customerToCustomerOutputDto(customerService.updateCustomer(id, mapper.customerDtoToCustomer(customerDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
