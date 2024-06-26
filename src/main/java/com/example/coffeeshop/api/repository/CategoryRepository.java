package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Boolean existsByName(String name);

    Optional<Category> findByName(String name);

}
