package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Customer;
import com.example.coffeeshop.api.entities.Invoice;
import com.example.coffeeshop.api.mapper.InvoiceMapper;
import com.example.coffeeshop.api.repository.InvoiceRepository;
import com.example.coffeeshop.api.web.invoice.CreateInvoiceDto;
import com.example.coffeeshop.api.web.invoice.InvoiceDto;
import com.example.coffeeshop.api.web.invoice.UpdateInvoiceDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InvoiceServiceImplement implements InvoiceService{

    private final InvoiceMapper invoiceMapper;
    private final InvoiceRepository invoiceRepository;

    @Override
    public void createNewInvoice(CreateInvoiceDto createInvoiceDto) {
        Invoice invoice = invoiceMapper.fromInvoiceDto(createInvoiceDto);
        invoice.setUuid(UUID.randomUUID().toString());
        invoice.setInvoiceDate(LocalDate.now());
        invoice.setIsDelete(false);
        invoiceRepository.save(invoice);
    }

    @Override
    public void updateInvoiceByUuid(String uuid, UpdateInvoiceDto updateInvoiceDto) {
        if (invoiceRepository.existsByUuid(uuid)){
            Invoice invoice = invoiceRepository.findByUuid(uuid).orElseThrow();
            invoiceMapper.fromUpdateInvoice(invoice, updateInvoiceDto);

            if (updateInvoiceDto.customerId() != null){
                Customer newCustomer = new Customer();
                newCustomer.setId(updateInvoiceDto.customerId());
                invoice.setCustomer(newCustomer);
            }

            invoiceRepository.save(invoice);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice at UUID : %s is not found...!", uuid));
    }

    @Transactional
    @Override
    public void updateInvoiceIsDeleteByUuid(String uuid) {
        if (invoiceRepository.existsByUuid(uuid)){
            invoiceRepository.editInvoiceIsDeleteByUuid(uuid);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice at UUID : %s is not found...!", uuid));
    }

    @Transactional
    @Override
    public void updateAllInvoiceIsDeleteByInvoiceDate(LocalDate date) {
        if (invoiceRepository.existsByInvoiceDate(date)){
            invoiceRepository.editAllInvoiceIsDeleteByInvoiceDate(date);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice at Date : %s is not found...!", date));
    }

    @Override
    public void deleteInvoiceByUuid(String uuid) {
        if (invoiceRepository.existsByUuid(uuid)){
            Invoice invoice = invoiceRepository.findByUuid(uuid).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Invoice at UUID : %s is not found...!", uuid))
            );

            invoiceRepository.delete(invoice);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteAllInvoiceByInvoiceDate(LocalDate date) {
        if (invoiceRepository.existsByInvoiceDate(date)){
            invoiceRepository.deleteAllByInvoiceDate(date);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice at Date : %s is not found...!", date));
    }

    @Override
    public InvoiceDto findInvoiceByUuid(String uuid) {
        Invoice invoice = invoiceRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice at UUID : %s is not found...!", uuid))
        );
        return invoiceMapper.toInvoiceDto(invoice);
    }

    @Override
    public List<InvoiceDto> findAll() {
//        List<Invoice> invoices = invoiceRepository.selectAllByIsDeleteIsFalse();
        List<Invoice> invoices = invoiceRepository.findAllByIsDeleteIsFalse();
        return invoiceMapper.toInoviceDtoList(invoices);
    }

    @Override
    public List<InvoiceDto> findAllByInvoiceDate(LocalDate date) {
        List<Invoice> invoices = invoiceRepository.findAllByInvoiceDate(date);
        return invoiceMapper.toInoviceDtoList(invoices);
    }

    @Override
    public List<InvoiceDto> findAllByIsDeleteIsTrue() {
        List<Invoice> invoices = invoiceRepository.findAllByIsDeleteIsFalse();
        return invoiceMapper.toInoviceDtoList(invoices);
    }
}
