package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

    Boolean existsByUuid(String uuid);

    Optional<SaleDetail> findByUuid(String uuid);

    @Query("SELECT SUM(SD.amount) FROM SaleDetail AS SD WHERE SD.sale.id = ?1")
    BigDecimal sumAllAmountOfSaleDetailBySaleId(Long saleId);

    @Query("SELECT SUM(SD.amount) FROM SaleDetail AS SD WHERE SD.sale.saleDate = ?1")
    BigDecimal sumAllAmountOfSaleDetailBySaleDate(LocalDate date);

    @Query("SELECT SUM(SD.amount) FROM SaleDetail AS SD WHERE SD.sale.saleDate BETWEEN ?1 AND ?2")
    BigDecimal sumAllAmountOfSaleDetailBetweenSaleDate(LocalDate firstDate, LocalDate lastDate);

    @Query("SELECT SD FROM SaleDetail AS SD WHERE SD.sale.uuid = ?1")
    List<SaleDetail> getAllSaleDetailBySaleUuid(String uuid);

    @Query("SELECT SD FROM SaleDetail AS SD WHERE SD.sale.id = ?1")
    List<SaleDetail> getAllSaleDetailBySaleId(Long id);

    @Query("SELECT SD FROM SaleDetail AS SD WHERE SD.sale.saleDate = ?1")
    List<SaleDetail> getAllBySaleDate(LocalDate date);

    @Query("SELECT SD FROM SaleDetail AS SD WHERE SD.sale.saleDate BETWEEN ?1 AND ?2")
    List<SaleDetail> getAllByBetweenDate(LocalDate firstDate, LocalDate lastDate);

}
