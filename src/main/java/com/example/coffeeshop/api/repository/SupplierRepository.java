package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Boolean existsByContactPhone(String contactPhone);

    Optional<Supplier> findByContactPhone(String contactPhone);

    Optional<Supplier> findByContactAddress(String contactAddress);

    Optional<Supplier> findByContactPhoneAndContactAddress(String contactPhone, String contactAddress);

}
