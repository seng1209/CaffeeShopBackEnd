package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.imports.CreateImportDto;
import com.example.coffeeshop.api.web.imports.ImportDto;
import com.example.coffeeshop.api.web.imports.UpdateImportDto;
import com.example.coffeeshop.api.web.imports.UpdateTotalAmountImportDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ImportService {

    // create import
    void createNewImport(CreateImportDto createImportDto);

    // update import by uuid
    void updateImportByUuid(String uuid, UpdateImportDto updateImportDto);

    // update import by id
    void updateImportById(Long id, UpdateTotalAmountImportDto updateTotalAmountImportDto);

    // update is_delete by uuid
    void updateImportIsDeleteByUuid(String uuid);

    // update all is_delete by date
    void updateAllImportIsDeleteByImportDate(LocalDate date);

    // delete by uuid
    void deleteImportByUuid(String uuid);

    // delete all by date
    void deleteAllImportByImportDate(LocalDate date);

    // select import by uuid
    ImportDto findByUuid(String uuid);

    // select all import is_delete is false
    List<ImportDto> findAll();

    // select all import by date
    List<ImportDto> findAllByImportDate(LocalDate date);

    // select all import by is_delete is true
    List<ImportDto> findAllByIsDeleteIsTrue();

    // select last import id
    Long findLastImportId();

}
