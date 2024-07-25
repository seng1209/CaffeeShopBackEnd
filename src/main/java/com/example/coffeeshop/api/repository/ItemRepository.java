package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Boolean existsByName(String name);

    Optional<Item> findByName(String name);

    @Query("SELECT I FROM Item AS I WHERE lower(I.name) LIKE lower(concat('%', ?1, '%') ) ")
    List<Item> findAllByName(String name);

}
