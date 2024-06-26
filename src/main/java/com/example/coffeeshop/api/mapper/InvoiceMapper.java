package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Invoice;
import com.example.coffeeshop.api.web.invoice.CreateInvoiceDto;
import com.example.coffeeshop.api.web.invoice.InvoiceDto;
import com.example.coffeeshop.api.web.invoice.UpdateInvoiceDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    // create invoice
    @Mapping(source = "customerId", target = "customer.id")
    Invoice fromInvoiceDto(CreateInvoiceDto createInvoiceDto);

    // update invoice
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateInvoice(@MappingTarget Invoice invoice, UpdateInvoiceDto updateInvoiceDto);

    @Mapping(source = "customer.name", target = "customer")
    InvoiceDto toInvoiceDto(Invoice invoice);

    List<InvoiceDto> toInoviceDtoList(List<Invoice> invoices);

}
