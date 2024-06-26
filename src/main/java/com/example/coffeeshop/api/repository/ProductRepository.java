package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByName(String name);

    Optional<Product> findByName(String name);

    @Query("SELECT P.saleUnitPrice FROM Product AS P WHERE P.id = ?1")
    BigDecimal selectSaleUnitPriceByProductId(Integer id);

}
