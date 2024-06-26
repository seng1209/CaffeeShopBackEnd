package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Boolean existsByUuid(String uuid);

    Boolean existsByInvoiceDate(LocalDate date);

    Optional<Invoice> findByUuid(String uuid);

    @Modifying
    @Query("UPDATE Invoice AS i SET i.isDelete = true WHERE i.uuid = ?1")
    void editInvoiceIsDeleteByUuid(String uuid);

    @Modifying
    @Query("UPDATE Invoice  AS i SET i.isDelete = true WHERE i.invoiceDate = ?1")
    void editAllInvoiceIsDeleteByInvoiceDate(LocalDate date);

    void deleteAllByInvoiceDate(LocalDate date);

//    @Query("SELECT Invoice AS i FROM Invoice WHERE i.isDelete = false ")
//    List<Invoice> selectAllByIsDeleteIsFalse();
    List<Invoice> findAllByIsDeleteIsFalse();

//    @Query("SELECT Invoice AS i FROM Invoice WHERE i.invoiceDate = ?1")
//    List<Invoice> selectAllByInvoiceDate(LocalDate date);
    List<Invoice> findAllByInvoiceDate(LocalDate date);

//    @Query("SELECT Invoice AS i FROM Invoice WHERE i.isDelete = true ")
//    List<Invoice> selectAllByIsDeleteIsTrue();
    List<Invoice> findAllByIsDeleteIsTrue();

}
