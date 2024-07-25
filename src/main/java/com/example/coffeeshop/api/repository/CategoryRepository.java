package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Boolean existsByName(String name);

    Optional<Category> findByName(String name);

    @Query("SELECT C FROM Category AS C WHERE lower(C.name) LIKE lower(concat('%', ?1, '%') ) ")
    List<Category> findAllByName(String name);

}
