package dev.prom.delivery.service;

import dev.prom.delivery.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product productDtoToProduct);

    Product updateProduct(Long id, Product productDtoToProduct);

    void deleteProduct(Long id);
}
