package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.invoice.CreateInvoiceDto;
import com.example.coffeeshop.api.web.invoice.InvoiceDto;
import com.example.coffeeshop.api.web.invoice.UpdateInvoiceDto;
import com.example.coffeeshop.api.web.invoice.UpdateTotalAmountInvoiceDto;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceService {

    // create invoice
    void createNewInvoice(CreateInvoiceDto createInvoiceDto);

    // update invoice by uuid
    void updateInvoiceByUuid(String uuid, UpdateInvoiceDto updateInvoiceDto);

    // update invoice by id
    void updateInvoiceById(Long id, UpdateInvoiceDto updateInvoiceDto);

    // update invoice is_delete by uuid
    void updateInvoiceIsDeleteByUuid(String uuid);

    // update all invoice is_delete by date
    void updateAllInvoiceIsDeleteByInvoiceDate(LocalDate date);

    // delete invoice by uuid
    void deleteInvoiceByUuid(String uuid);

    // delete all invoice by date
    void deleteAllInvoiceByInvoiceDate(LocalDate date);

    // select invoice by uuid
    InvoiceDto findInvoiceByUuid(String uuid);

    // select all invoice (is_delete = false)
    List<InvoiceDto> findAll();

    // select all invoice by date (is_delete = false)
    List<InvoiceDto> findAllByInvoiceDate(LocalDate date);

    // select all invoice by is_delete = true
    List<InvoiceDto> findAllByIsDeleteIsTrue();

    // get last id
    Long getLastInvoiceId();

    // update total amount by uuid
    void updateTotalAmount(Long invoiceId, UpdateTotalAmountInvoiceDto updateTotalAmountInvoiceDto);

    // find by invoice id
    InvoiceDto findById(Long id);

    // find by customer
    List<InvoiceDto> findAllByCustomer(String customer);

}
