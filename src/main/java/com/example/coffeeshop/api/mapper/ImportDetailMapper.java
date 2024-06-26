package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.ImportDetail;
import com.example.coffeeshop.api.web.import_detail.CreateImportDetail;
import com.example.coffeeshop.api.web.import_detail.ImportDetailDto;
import com.example.coffeeshop.api.web.import_detail.UpdateImportDetail;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImportDetailMapper {

    // create
    @Mapping(source = "importId", target = "imports.id")
    @Mapping(source = "itemId", target = "items.id")
    ImportDetail fromImportDetailDto(CreateImportDetail createImportDetail);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateImportDetailDto(@MappingTarget ImportDetail importDetail, UpdateImportDetail updateImportDetail);

    // select a
    @Mapping(source = "imports.id", target = "importId")
    @Mapping(source = "imports.uuid", target = "imports")
    @Mapping(source = "items.id", target = "itemId")
    @Mapping(source = "items.name", target = "items")
    ImportDetailDto toImportDetailDto(ImportDetail importDetail);

    // select all
    List<ImportDetailDto> toImportDetailDtoList(List<ImportDetail> importDetails);

}