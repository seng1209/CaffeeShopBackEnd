package com.example.coffeeshop.api.repository;

import com.example.coffeeshop.api.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {

    Boolean existsByUuid(String uuid);

    Optional<InvoiceDetail> findByUuid(String uuid);

    List<InvoiceDetail> findAllByIsDeletedIsFalse();

    @Modifying
    @Query("UPDATE InvoiceDetail AS ID SET ID.isDeleted = ?2 WHERE ID.uuid = ?1")
    void editInvoiceDetailByUuid(String uuid, Boolean isDelete);

    @Query("SELECT SUM(ID.productTotal) FROM InvoiceDetail AS ID WHERE ID.invoice.id = ?1")
    BigDecimal getProductTotal(Long invoiceId);

    List<InvoiceDetail> findAllByInvoiceUuid(String uuid);

}
