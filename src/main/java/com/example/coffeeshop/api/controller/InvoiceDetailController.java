package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.InvoiceDetailService;
import com.example.coffeeshop.api.web.invoice_detail.CreateInvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.InvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.UpdateInvoiceDetailDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v2/invoice_detail")
@AllArgsConstructor
public class InvoiceDetailController {

    private final InvoiceDetailService invoiceDetailService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createInvoiceDetail(@RequestBody @Valid CreateInvoiceDetailDto createInvoiceDetailDto){
        invoiceDetailService.createInvoiceDetail(createInvoiceDetailDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateInvoiceDetailByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateInvoiceDetailDto updateInvoiceDetailDto){
        invoiceDetailService.updateInvoiceDetailByUuid(uuid, updateInvoiceDetailDto);
    }

    @PatchMapping("/id/{id}")
    public void updateInvoiceDetailById(@PathVariable Long id, @RequestBody @Valid UpdateInvoiceDetailDto updateInvoiceDetailDto){
        invoiceDetailService.updateInvoiceDetailById(id, updateInvoiceDetailDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public void deleteInvoiceDetailByUuid(@PathVariable String uuid){
        invoiceDetailService.deleteInvoiceDetailByUuid(uuid);
    }

    @GetMapping("/{uuid}")
    public InvoiceDetailDto findByUuid(@PathVariable String uuid){
        return invoiceDetailService.findByUuid(uuid);
    }

    @GetMapping
    public List<InvoiceDetailDto> findAll(){
        return invoiceDetailService.findAll();
    }

    @GetMapping("/product_total/{invoiceId}")
    public BigDecimal getProductTotal(@PathVariable Long invoiceId){
        return invoiceDetailService.getProductTotal(invoiceId);
    }

    @GetMapping("/invoice_uuid/{uuid}")
    public List<InvoiceDetailDto> findAllInvoiceDetailByInvoiceUuid(@PathVariable String uuid){
        return invoiceDetailService.findAllInvoiceDetailByInvoiceUuid(uuid);
    }

}
