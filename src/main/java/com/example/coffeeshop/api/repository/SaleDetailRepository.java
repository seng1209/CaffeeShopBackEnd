package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

    Boolean existsByUuid(String uuid);

    Optional<SaleDetail> findByUuid(String uuid);

    @Query("SELECT SUM(SD.amount) FROM SaleDetail AS SD WHERE SD.sale.id = ?1")
    BigDecimal sumAllAmountOfSaleDetailBySaleId(Long saleId);

}
