package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.invoice_detail.CreateInvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.InvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.UpdateInvoiceDetailDto;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceDetailService {

    // create invoice detail
    void createInvoiceDetail(CreateInvoiceDetailDto createInvoiceDetailDto);

    // update invoice detail by uuid
    void updateInvoiceDetailByUuid(String uuid, UpdateInvoiceDetailDto updateInvoiceDetailDto);

    // update invoice detail by id
    void updateInvoiceDetailById(Long id, UpdateInvoiceDetailDto updateInvoiceDetailDto);

    // update is delete by uuid
    void deleteInvoiceDetailByUuid(String uuid);

    // select invoice detail by uuid
    InvoiceDetailDto findByUuid(String uuid);

    // select all invoice detail
    List<InvoiceDetailDto> findAll();

    // get product total
    BigDecimal getProductTotal(Long invoiceId);

    // get all invoice_detail by invoice_uuid
    List<InvoiceDetailDto> findAllInvoiceDetailByInvoiceUuid(String uuid);
}
