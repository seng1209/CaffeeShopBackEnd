package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Boolean existsByPhone(String phone);

    Optional<Customer> findByPhone(String phone);

    List<Customer> findAllByNameOrPhone(String name, String phone);

    @Query("SELECT C FROM Customer AS C WHERE lower(C.name) LIKE lower(concat('%', ?1, '%') ) ")
    List<Customer> findAllByName(String name);

    @Query("SELECT C FROM Customer AS C WHERE C.phone LIKE %?1%")
    List<Customer> findByPhoneNumber(String phone);

    @Query("SELECT C FROM Customer AS C WHERE lower(C.type) LIKE lower(concat('%', ?1, '%') ) ")
    List<Customer> findAllByType(String type);

}
