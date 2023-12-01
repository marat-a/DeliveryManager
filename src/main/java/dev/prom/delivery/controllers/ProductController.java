package dev.prom.delivery.controllers;

import dev.prom.delivery.dto.ProductDto;
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

     ProductMapper mapper;


    @GetMapping
    public List<ProductDto> getAllProducts() {
        return mapper.productsToProductDtos(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return mapper.productToProductDto(productService.getProductById(id));
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return mapper.productToProductDto(productService.createProduct(mapper.productDtoToProduct(productDto)));
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return mapper.productToProductDto(productService.updateProduct(id, mapper.productDtoToProduct(productDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
