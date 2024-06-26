package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.InvoiceService;
import com.example.coffeeshop.api.web.invoice.CreateInvoiceDto;
import com.example.coffeeshop.api.web.invoice.InvoiceDto;
import com.example.coffeeshop.api.web.invoice.UpdateInvoiceDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/invoices")
@AllArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewInvoice(@RequestBody @Valid CreateInvoiceDto createInvoiceDto){
        invoiceService.createNewInvoice(createInvoiceDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateInvoiceByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateInvoiceDto updateInvoiceDto){
        invoiceService.updateInvoiceByUuid(uuid, updateInvoiceDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public void updateInvoiceIsDeleteByUuid(@PathVariable String uuid){
        invoiceService.updateInvoiceIsDeleteByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{date}")
    public void updateAllInvoiceIsDeleteByInvoiceDate(@PathVariable LocalDate date){
        invoiceService.updateAllInvoiceIsDeleteByInvoiceDate(date);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteInvoiceByUuid(@PathVariable String uuid){
        invoiceService.deleteInvoiceByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{date}")
    public void deleteAllInvoiceByInvoiceDate(@PathVariable LocalDate date){
        invoiceService.deleteAllInvoiceByInvoiceDate(date);
    }

    @GetMapping("/{uuid}")
    public InvoiceDto findInvoiceByUuid(@PathVariable String uuid){
        return invoiceService.findInvoiceByUuid(uuid);
    }

    @GetMapping
    public List<InvoiceDto> findAll(){
        return invoiceService.findAll();
    }

    @GetMapping("/{date}")
    public List<InvoiceDto> findAllByInvoiceDate(@PathVariable LocalDate date){
        return invoiceService.findAllByInvoiceDate(date);
    }

    @GetMapping("/true")
    public List<InvoiceDto> findAllByIsDeleteIsTrue(){
        return invoiceService.findAllByIsDeleteIsTrue();
    }

}
