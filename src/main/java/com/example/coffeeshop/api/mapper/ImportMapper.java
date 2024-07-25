package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Import;
import com.example.coffeeshop.api.web.imports.CreateImportDto;
import com.example.coffeeshop.api.web.imports.ImportDto;
import com.example.coffeeshop.api.web.imports.UpdateImportDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImportMapper {

    // create import

    /**
     * map to create import. mapping "DTO" to "Entity"
     * mapping set value staffId to staff.id
     * mapping set value supplierId to supplier.id
     * @param createImportDto
     * @return
     */
    @Mapping(source = "staffId", target = "staff.id")
    @Mapping(source = "supplierId", target = "supplier.id")
    Import fromImportDto(CreateImportDto createImportDto);

    // update import

    /**
     * map to update import
     * @param imports
     * @param updateImportDto
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateImportDto(@MappingTarget Import imports, UpdateImportDto updateImportDto);

    // select import

    /**
     * map "Entity" to "Dto"
     * mapping get value staff.name from staff
     * mapping get value supplier.name from supplier
     * @param imports
     * @return
     */
    @Mapping(source = "staff.id", target = "staffId")
    @Mapping(source = "staff.name", target = "staff")
    @Mapping(source = "staff.phone", target = "staffPhone")
    @Mapping(source = "staff.position", target = "staffPosition")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplier.name", target = "supplier")
    @Mapping(source = "supplier.contactPhone", target = "supplierPhone")
    ImportDto toImportDto(Import imports);

    // select all import
    List<ImportDto> toImportDtoList(List<Import> imports);

}
