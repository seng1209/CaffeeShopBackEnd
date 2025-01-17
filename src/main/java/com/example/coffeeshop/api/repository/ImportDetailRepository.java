package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.ImportDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ImportDetailRepository extends JpaRepository<ImportDetail, Long> {

    Boolean existsByUuid(String uuid);

    Optional<ImportDetail> findByUuid(String uuid);

    @Query("SELECT SUM(ID.amount) FROM ImportDetail AS ID WHERE ID.imports.id = ?1")
    BigDecimal totalAmount(Long importsId);

    @Query("SELECT SUM(ID.amount) FROM ImportDetail AS ID WHERE ID.imports.importDate = ?1")
    BigDecimal getTotalAmountByImportDate(LocalDate date);

    @Query("SELECT SUM(ID.amount) FROM ImportDetail AS ID WHERE ID.imports.importDate BETWEEN ?1 AND ?2")
    BigDecimal getTotalAmountBetweenImportDate(LocalDate firstDate, LocalDate lastDate);

    @Query("SELECT ID FROM ImportDetail AS ID WHERE ID.imports.id = ?1")
    List<ImportDetail> selectAllImportDetailByImportId(Long importId);

    @Query("SELECT ID FROM ImportDetail AS ID WHERE ID.imports.uuid = ?1")
    List<ImportDetail> selectAllImportDetailByImportUuid(String uuid);

    @Query("SELECT ID FROM ImportDetail AS ID WHERE ID.imports.importDate = ?1")
    List<ImportDetail> selectAllImportDetailByImportDate(LocalDate date);

    @Query("SELECT ID FROM ImportDetail AS ID WHERE ID.imports.importDate BETWEEN ?1 AND ?2")
    List<ImportDetail> selectAllImportDetailBetweenImportDate(LocalDate firstDate, LocalDate lastDate);

}
