package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Boolean existsByPhone(String phone);

    Optional<Customer> findByPhone(String phone);

    List<Customer> findAllByNameOrPhone(String name, String phone);

}
