package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.InvoiceDetail;
import com.example.coffeeshop.api.web.invoice_detail.CreateInvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.InvoiceDetailDto;
import com.example.coffeeshop.api.web.invoice_detail.UpdateInvoiceDetailDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceDetailMapper {

    // create
    @Mapping(source = "invoiceId", target = "invoice.id")
    @Mapping(source = "productId", target = "product.id")
    InvoiceDetail fromInvoiceDetailDto(CreateInvoiceDetailDto createInvoiceDetailDto);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateInvoiceDetailDto(@MappingTarget InvoiceDetail invoiceDetail, UpdateInvoiceDetailDto updateInvoiceDetailDto);

    // select a
    @Mapping(source = "invoice.id", target = "invoiceId")
    @Mapping(source = "invoice.uuid", target = "invoice")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "product")
    InvoiceDetailDto toInvoiceDetailDto(InvoiceDetail invoiceDetail);

    // select all
    List<InvoiceDetailDto> toInvoiceDetailDtoList (List<InvoiceDetail> invoiceDetails);
}
