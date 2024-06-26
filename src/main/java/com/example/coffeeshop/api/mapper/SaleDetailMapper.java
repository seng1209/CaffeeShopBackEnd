package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.SaleDetail;
import com.example.coffeeshop.api.web.sale_detail.CreateSaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.SaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.UpdateSaleDetailDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    // create
    @Mapping(source = "saleId", target = "sale.id")
    @Mapping(source = "productId", target = "product.id")
    SaleDetail fromSaleDetailDto(CreateSaleDetailDto createSaleDetailDto);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateSaleDetailDto(@MappingTarget SaleDetail saleDetail, UpdateSaleDetailDto updateSaleDetailDto);

    // select a
    @Mapping(source = "sale.uuid", target = "sale")
    @Mapping(source = "product.name", target = "product")
    SaleDetailDto toSaleDetailDto(SaleDetail saleDetail);

    // select all
    List<SaleDetailDto> toSaleDetailDtoList(List<SaleDetail> saleDetails);

}
