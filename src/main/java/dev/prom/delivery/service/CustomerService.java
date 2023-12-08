package dev.prom.delivery.service;



import dev.prom.delivery.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerService {
    void deleteCustomer(Long id);

    Customer updateCustomer(Long id, Customer customer);

    Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    boolean isCustomerExists(Long id);
}
