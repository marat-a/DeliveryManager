package dev.prom.delivery.mappers;

import dev.prom.delivery.dto.ProductDto;
import dev.prom.delivery.dto.ProductOutputDto;
import dev.prom.delivery.models.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);

    List<ProductOutputDto> productsToProductOutputDtos(List<Product> products);
    ProductOutputDto productToProductOutputDto(Product product);

}