package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Category;
import com.example.coffeeshop.api.entities.Item;
import com.example.coffeeshop.api.entities.Product;
import com.example.coffeeshop.api.mapper.ProductMapper;
import com.example.coffeeshop.api.repository.ProductRepository;
import com.example.coffeeshop.api.web.product.CreateProductDto;
import com.example.coffeeshop.api.web.product.ProductDto;
import com.example.coffeeshop.api.web.product.UpdateProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public void createNewProduct(CreateProductDto createProductDto) {
        Product product = productMapper.formProductDto(createProductDto);
        productRepository.save(product);
    }

    @Override
    public void updateProductByName(String name, UpdateProductDto updateProductDto) {
        if (productRepository.existsByName(name)){
            Product product = productRepository.findByName(name).orElseThrow();
            productMapper.formUpdateProductDto(product, updateProductDto);

            if (updateProductDto.categoryId() != null) {
                Category newCategory = new Category();
                newCategory.setId(updateProductDto.categoryId());
                product.setCategory(newCategory);
            }

            productRepository.save(product);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Product name : %s is not found!...", name));
    }

    @Override
    public void deleteProductByName(String name) {
        Product product = productRepository.findByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Product name : %s is not found!...", name))
        );
        productRepository.delete(product);
    }

    @Override
    public ProductDto findProductByName(String name) {
        Product product = productRepository.findByName(name).orElseThrow(
                () -> new  ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Product name : %s is not found!...", name))
        );
        return productMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDtoList(products);
    }

    @Override
    public BigDecimal getSaleUnitPriceByProductId(Integer productId) {
        return productRepository.selectSaleUnitPriceByProductId(productId);
    }
}
