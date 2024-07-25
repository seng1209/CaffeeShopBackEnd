package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Sale;
import com.example.coffeeshop.api.web.sale.CreateSaleDto;
import com.example.coffeeshop.api.web.sale.SaleDto;
import com.example.coffeeshop.api.web.sale.UpdateSaleDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    // create sale
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "staffId", target = "staff.id")
    @Mapping(source = "paymentId", target = "payment.id")
    @Mapping(source = "deliveryId", target = "delivery.id")
    Sale fromSaleDto(CreateSaleDto createSaleDto);

    // update sale
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateSaleDto(@MappingTarget Sale sale, UpdateSaleDto updateSaleDto);

    // select sale
    @Mapping(source = "customer.name", target = "customer")
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "staff.name", target = "staff")
    @Mapping(source = "staff.id", target = "staffId")
    @Mapping(source = "payment.id", target = "paymentId")
    @Mapping(source = "payment.uuid", target = "paymentUuid")
    @Mapping(source = "delivery.id", target = "deliveryId")
    SaleDto toSaleDto(Sale sale);

    // select all sale
    List<SaleDto> toSaleDtoList(List<Sale> sales);

}
