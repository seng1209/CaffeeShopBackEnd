package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Boolean existsByContactPhone(String contactPhone);

    Optional<Supplier> findByContactPhone(String contactPhone);

    Optional<Supplier> findByContactAddress(String contactAddress);

    Optional<Supplier> findByContactPhoneAndContactAddress(String contactPhone, String contactAddress);

    @Query("SELECT S FROM Supplier AS S WHERE lower(S.name) LIKE lower(concat('%', ?1, '%') ) ")
    List<Supplier> findAllByName(String name);

    @Query("SELECT S FROM Supplier AS S WHERE S.contactPhone LIKE %?1%")
    List<Supplier> findByPhone(String phone);

}
