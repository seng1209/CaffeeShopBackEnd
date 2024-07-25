package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.product.CreateProductDto;
import com.example.coffeeshop.api.web.product.ProductDto;
import com.example.coffeeshop.api.web.product.UpdateProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    // create product
    void createNewProduct(CreateProductDto createProductDto);

    // update product
    void updateProductByName(String name, UpdateProductDto updateProductDto);

    // delete product by name
    void deleteProductByName(String name);

    // select a product by name
    ProductDto findProductByName(String name);

    // select all products
    List<ProductDto> findAll();

    // get sale_unit_price by product id
    BigDecimal getSaleUnitPriceByProductId(Integer productId);

    // get product like name '%()%'
    List<ProductDto> findByLikeName(String name);

    // popular products
    List<ProductDto> popular();

    // select by id
    ProductDto findById(Integer id);

    // select by category name
    List<ProductDto> findByCategory(String category);
}
