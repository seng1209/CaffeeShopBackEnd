package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Invoice;
import com.example.coffeeshop.api.entities.InvoiceDetail;
import com.example.coffeeshop.api.entities.Product;
import com.example.coffeeshop.api.mapper.InvoiceDetailMapper;
import com.example.coffeeshop.api.repository.InvoiceDetailRepository;
import com.example.coffeeshop.api.web.invoice_detail.CreateInvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.InvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.UpdateInvoiceDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InvoiceDetailServiceImplement implements InvoiceDetailService{

    private final InvoiceDetailMapper invoiceDetailMapper;
    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public void createInvoiceDetail(CreateInvoiceDetailDto createInvoiceDetailDto) {
        InvoiceDetail invoiceDetail = invoiceDetailMapper.fromInvoiceDetailDto(createInvoiceDetailDto);
        invoiceDetail.setUuid(UUID.randomUUID().toString());
        invoiceDetail.setIsDeleted(false);
        invoiceDetail.setProductTotal(createInvoiceDetailDto.unitPrice()
                .multiply(BigDecimal.valueOf(createInvoiceDetailDto.quantity()))
        );
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public void updateInvoiceDetailByUuid(String uuid, UpdateInvoiceDetailDto updateInvoiceDetailDto) {
        if (invoiceDetailRepository.existsByUuid(uuid)){
            InvoiceDetail invoiceDetail = invoiceDetailRepository.findByUuid(uuid).orElseThrow();
            invoiceDetailMapper.fromUpdateInvoiceDetailDto(invoiceDetail, updateInvoiceDetailDto);

            if (updateInvoiceDetailDto.invoiceId() != null){
                Invoice newInvoice = new Invoice();
                newInvoice.setId(updateInvoiceDetailDto.invoiceId());
                invoiceDetail.setInvoice(newInvoice);
            }

            if (updateInvoiceDetailDto.productId() != null){
                Product newProduct = new Product();
                newProduct.setId(updateInvoiceDetailDto.productId());
                invoiceDetail.setProduct(newProduct);
            }
            invoiceDetail.setProductTotal(updateInvoiceDetailDto.unitPrice().multiply(BigDecimal.valueOf(updateInvoiceDetailDto.quantity())));
            invoiceDetailRepository.save(invoiceDetail);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice Detail ad UUID : %s not found...!", uuid));
    }

    @Override
    public void updateInvoiceDetailById(Long id, UpdateInvoiceDetailDto updateInvoiceDetailDto) {
        if (invoiceDetailRepository.existsById(id)){
            InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElseThrow();
            invoiceDetailMapper.fromUpdateInvoiceDetailDto(invoiceDetail, updateInvoiceDetailDto);

            if (updateInvoiceDetailDto.invoiceId() != null){
                Invoice newInvoice = new Invoice();
                newInvoice.setId(updateInvoiceDetailDto.invoiceId());
                invoiceDetail.setInvoice(newInvoice);
            }

            if (updateInvoiceDetailDto.productId() != null){
                Product newProduct = new Product();
                newProduct.setId(updateInvoiceDetailDto.productId());
                invoiceDetail.setProduct(newProduct);
            }
            invoiceDetail.setProductTotal(updateInvoiceDetailDto.unitPrice().multiply(BigDecimal.valueOf(updateInvoiceDetailDto.quantity())));
            invoiceDetailRepository.save(invoiceDetail);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice Detail ad ID : %s not found...!", id));
    }

    @Transactional
    @Override
    public void deleteInvoiceDetailByUuid(String uuid) {
        if (invoiceDetailRepository.existsByUuid(uuid)){
            invoiceDetailRepository.editInvoiceDetailByUuid(uuid, true);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice Detail ad UUID : %s not found...!", uuid));
    }

    @Override
    public InvoiceDetailDto findByUuid(String uuid) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invoice Detail ad UUID : %s not found...!", uuid))
        );
        return invoiceDetailMapper.toInvoiceDetailDto(invoiceDetail);
    }

    @Override
    public List<InvoiceDetailDto> findAll() {
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findAllByIsDeletedIsFalse();
        return invoiceDetailMapper.toInvoiceDetailDtoList(invoiceDetails);
    }

    @Override
    public BigDecimal getProductTotal(Long invoiceId) {
        return invoiceDetailRepository.getProductTotal(invoiceId);
    }

    @Override
    public List<InvoiceDetailDto> findAllInvoiceDetailByInvoiceUuid(String uuid) {
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findAllByInvoiceUuid(uuid);
        return invoiceDetailMapper.toInvoiceDetailDtoList(invoiceDetails);
    }
}
