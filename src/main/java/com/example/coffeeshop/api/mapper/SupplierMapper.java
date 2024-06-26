package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Supplier;
import com.example.coffeeshop.api.web.supllier.CreateSupplierDto;
import com.example.coffeeshop.api.web.supllier.SupplierDto;
import com.example.coffeeshop.api.web.supllier.UpdateSupplierDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    // create supplier
    Supplier formSupplierDto(CreateSupplierDto createSupplierDto);

    // update supplier by contact phone
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateSupplierDto(@MappingTarget Supplier supplier, UpdateSupplierDto updateSupplierDto);

    // select a supplier
    SupplierDto toSupplierDto(Supplier supplier);

    // select all supplier
    List<SupplierDto> toSupplierDtoList(List<Supplier> suppliers);

}
