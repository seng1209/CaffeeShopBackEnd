package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ImportRepository extends JpaRepository<Import, Long> {

    Boolean existsByUuid(String uuid);

    Boolean existsByImportDate(LocalDate date);

//    boolean existsById(Long id);

    Optional<Import> findByUuid(String uuid);

//    Optional<Import> findById(Long id);

    @Modifying
    @Query("UPDATE Import AS i SET i.isDelete = true WHERE i.uuid = ?1")
    void editImportIsDeleteByUuid(String uuid);

    @Modifying
    @Query("UPDATE Import  AS i SET i.isDelete = true WHERE i.importDate = ?1")
    void editAllImportIsDeleteByImportDate(LocalDate date);

    @Query("SELECT MAX(id) FROM Import")
    Long findLastImportId();

    List<Import> findAllByImportDateAndIsDeleteIsFalse(LocalDate importDate);

    List<Import> findAllByIsDeleteIsTrue();

    List<Import> findAllByIsDeleteIsFalse();

    @Modifying
    @Query("UPDATE Import AS I SET I.totalAmount = ?2 WHERE I.id = ?1 ")
    void editTotalAmount(Long id, BigDecimal totalAmount);

    @Query("SELECT IP FROM Import IP WHERE lower(IP.staff.name) LIKE lower(concat('%',?1,'%') ) ")
    List<Import> findAllByStaffName(String name);

    @Query("SELECT IP FROM Import AS IP WHERE lower(IP.supplier.name) LIKE lower(concat('%',?1,'%') ) ")
    List<Import> findAllBySupplierName(String name);

}
