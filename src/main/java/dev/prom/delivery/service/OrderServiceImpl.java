package dev.prom.delivery.service;

import dev.prom.delivery.enums.ProgressStatus;
import dev.prom.delivery.exceptions.NotFoundException;
import dev.prom.delivery.models.Customer;
import dev.prom.delivery.models.Order;
import dev.prom.delivery.models.Product;
import dev.prom.delivery.repository.OrderRepository;
import dev.prom.delivery.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    @PersistenceContext
    private EntityManager entityManager;


    public OrderServiceImpl(OrderRepository orderRepository, CustomerService customerService, ProductService productService,
                            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            customerService.deleteOrderById(getOrderById(id).getCustomer().getId(), id);
            orderRepository.deleteById(id);
        } else throw new NotFoundException("Order not found");
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
        } else throw new NotFoundException("Order not found");
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        if (order.getProgressStatus() == null) {
            order.setProgressStatus(ProgressStatus.NOTAPPROVED);
        }
        if (order.getProducts() != null) {
            for (Product product : order.getProducts()) {
                if (product.getId() == null) {
                    product = productService.createProduct(product);
                } else product = productService.getProductById(product.getId());
            }
        }
        if (order.getCustomer().getId() == null) {
            customerService.createCustomer(order.getCustomer());
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            order.getCustomer().setOrders(orderList);
        } else {
            Customer customer = customerService.getCustomerById(order.getCustomer().getId());
            customer.getOrders().add(order);
            order.setCustomer(customer);
        }

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order changeStatus(Long orderId, ProgressStatus status, long courierId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found"));
        if (order.getDeliveryInfo().getCourier().getId() == courierId) {
            order.setProgressStatus(status);
        }
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByCourier(Long courierId) {
        return orderRepository.findAllByDeliveryInfoCourierId(courierId);
    }
}
