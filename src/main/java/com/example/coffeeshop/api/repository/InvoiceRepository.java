package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
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
    List<Invoice> findAllByIsDeleteIsFalse();

    List<Invoice> findAllByInvoiceDate(LocalDate date);

    List<Invoice> findAllByIsDeleteIsTrue();

    @Query("SELECT MAX(I.id) FROM Invoice AS I")
    Long getLastInvoiceID();

    @Modifying
    @Query("UPDATE Invoice AS I SET I.totalAmount = ?2 WHERE I.id = ?1")
    void editTotalAmount(Long invoiceId, BigDecimal totalAmount);

    @Query("SELECT I FROM Invoice AS I WHERE lower(I.customer.name) LIKE lower(concat('%',?1,'%') ) ")
    List<Invoice> findAllByCustomer(String customer);

}
