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

//    @Query("""
//    SELECT import FROM Import AS import WHERE import.importDate = ?1 AND import.isDelete = ?2
//    """)
//    @Query("SELECT Import AS i FROM Import WHERE i.importDate = ?1 AND i.isDelete = ?2 ")
//    List<Import> selectAllByImportDateAndIsDeleteIsFalse(LocalDate date, Boolean isDelete);
    List<Import> findAllByImportDateAndIsDeleteIsFalse(LocalDate importDate);

//    @Query("SELECT Import AS i FROM Import WHERE i.isDelete = true ")
//    List<Import> selectAllByIsDeleteIsTrue();
    List<Import> findAllByIsDeleteIsTrue();

//    @Query("SELECT Import AS i FROM Import WHERE i.isDelete = ?1 ")
//    List<Import> selectAll(Boolean isDelete);
    List<Import> findAllByIsDeleteIsFalse();

    @Modifying
    @Query("UPDATE Import AS I SET I.totalAmount = ?2 WHERE I.id = ?1")
    void editTotalAmount(Long id, BigDecimal totalAmount);

}
