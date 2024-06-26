package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Product;
import com.example.coffeeshop.api.web.product.CreateProductDto;
import com.example.coffeeshop.api.web.product.ProductDto;
import com.example.coffeeshop.api.web.product.UpdateProductDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // create product
    @Mapping(source = "categoryId", target = "category.id")
    Product formProductDto(CreateProductDto createProductDto);

    // update product
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateProductDto(@MappingTarget Product product, UpdateProductDto updateProductDto);

    // select a product
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "category")
    ProductDto toProductDto(Product product);

    // select all products
    List<ProductDto> toProductDtoList(List<Product> products);

}
