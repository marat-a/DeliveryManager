package dev.prom.delivery.controllers;

import dev.prom.delivery.dto.ProductDto;
import dev.prom.delivery.dto.ProductOutputDto;
import dev.prom.delivery.mappers.ProductMapper;
import dev.prom.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@ResponseBody
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper mapper;


    @GetMapping
    public List<ProductOutputDto> getAllProducts() {
        return mapper.productsToProductOutputDtos(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ProductOutputDto getProductById(@PathVariable Long id) {
        return mapper.productToProductOutputDto(productService.getProductById(id));
    }

    @PostMapping
    public ProductOutputDto createProduct(@RequestBody ProductDto productDto) {
        return mapper.productToProductOutputDto(productService.createProduct(mapper.productDtoToProduct(productDto)));
    }

    @PutMapping("/{id}")
    public ProductOutputDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return mapper.productToProductOutputDto(productService.updateProduct(id, mapper.productDtoToProduct(productDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
