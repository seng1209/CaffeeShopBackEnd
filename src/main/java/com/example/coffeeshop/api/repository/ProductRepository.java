package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByName(String name);

    Optional<Product> findByName(String name);

    @Query("SELECT P.saleUnitPrice FROM Product AS P WHERE P.id = ?1")
    BigDecimal selectSaleUnitPriceByProductId(Integer id);

    @Query("SELECT P FROM Product AS P WHERE LOWER(P.name) LIKE LOWER( CONCAT('%', ?1, '%') ) ")
    List<Product> findAllByLikeName(String name);

    @Query("SELECT p.name, COUNT(sd.product.id) AS total_sales, p.saleUnitPrice\n" +
            "FROM Product p\n" +
            "         INNER JOIN SaleDetail sd ON sd.product.id = p.id\n" +
            "GROUP BY p.id\n" +
            "ORDER BY total_sales DESC\n" +
            "LIMIT 10")
    List<Product> popular();

    @Query("SELECT P FROM Product AS P WHERE lower(P.category.name) LIKE lower(concat('%', ?1, '%') ) ")
    List<Product> findAllByCategory(String category);

}
