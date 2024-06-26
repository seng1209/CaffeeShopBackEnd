package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.ProductService;
import com.example.coffeeshop.api.web.product.CreateProductDto;
import com.example.coffeeshop.api.web.product.ProductDto;
import com.example.coffeeshop.api.web.product.UpdateProductDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewProduct(@RequestBody @Valid CreateProductDto createProductDto){
        productService.createNewProduct(createProductDto);
    }

    @GetMapping
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{name}")
    public ProductDto findProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{name}")
    public void updateProductByName(@PathVariable String name, @RequestBody @Valid UpdateProductDto updateProductDto){
        productService.updateProductByName(name, updateProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void deleteProductByName(@PathVariable String name){
        productService.deleteProductByName(name);
    }

    @GetMapping("/sale_unit_price/{productId}")
    public BigDecimal getSaleUnitPriceByProductId(@PathVariable Integer productId){
        return productService.getSaleUnitPriceByProductId(productId);
    }

}
