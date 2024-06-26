package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Boolean existsByUuid(String uuid);

    Boolean existsByDeliveryDate(LocalDate date);

    Optional<Delivery> findByUuid(String uuid);

    List<Delivery> findAllByDeliveryDate(LocalDate date);

}
