package dev.prom.delivery.service;

import dev.prom.delivery.enums.Role;
import dev.prom.delivery.exceptions.NotFoundException;
import dev.prom.delivery.models.Customer;
import dev.prom.delivery.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else throw new NotFoundException("Customer not found");
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
        } else throw new NotFoundException("Customer not found");
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setRole(Role.CUSTOMER);
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    @Override
    public boolean isCustomerExists(Long id) {

        return customerRepository.existsById(id);
    }

    @Override
    public void deleteOrderById(Long customerId, Long orderId) {
getCustomerById(customerId).getOrders().removeIf(order -> Objects.equals(order.getId(), orderId));

    }
}
