package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Boolean existsByUuid(String uuid);

    Boolean existsBySaleDate(LocalDate date);

    Optional<Sale> findByUuid(String uuid);

    List<Sale> findAllBySaleDate(LocalDate date);

    @Query("SELECT MAX(S.id) FROM Sale AS S")
    Long getLastSaleId();

    @Modifying
    @Query("UPDATE Sale AS S SET S.totalAmount = ?2 WHERE S.id = ?1")
    void editTotalAmountBySaleId(Long saleId, BigDecimal totalAmount);

}
