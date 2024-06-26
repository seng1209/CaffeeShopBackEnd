package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Boolean existsByName(String name);

    Optional<Item> findByName(String name);

}
