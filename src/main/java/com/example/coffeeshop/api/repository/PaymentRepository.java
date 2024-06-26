package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Boolean existsByUuid(String uuid);

    Boolean existsByPaymentDate(LocalDate paymentDate);

    Optional<Payment> findByUuid(String uuid);

    List<Payment> findAllByPaymentDate(LocalDate paymentDate);

    @Modifying
    @Query("UPDATE Payment AS pm SET pm.isDelete = true WHERE pm.uuid = ?1")
    void editPaymentIsDeleteIsTrueByUuid(String uuid);

    @Modifying
    @Query("UPDATE Payment AS pm SET pm.isDelete = true WHERE pm.paymentDate = ?1")
    void editAllPaymentIsDeleteIsTrueByPaymentDate(LocalDate paymentDate);

}
