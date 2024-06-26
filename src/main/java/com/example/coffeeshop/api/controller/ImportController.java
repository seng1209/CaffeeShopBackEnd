package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.ImportService;
import com.example.coffeeshop.api.web.imports.CreateImportDto;
import com.example.coffeeshop.api.web.imports.ImportDto;
import com.example.coffeeshop.api.web.imports.UpdateImportDto;
import com.example.coffeeshop.api.web.imports.UpdateTotalAmountImportDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/imports")
@AllArgsConstructor
public class ImportController {

    private final ImportService importService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewImport(@RequestBody @Valid CreateImportDto createImportDto){
        importService.createNewImport(createImportDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateImportByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateImportDto updateImportDto){
        importService.updateImportByUuid(uuid, updateImportDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/total_amount/{id}")
    public void updateImportById(@PathVariable Long id, @RequestBody @Valid UpdateTotalAmountImportDto updateTotalAmountImportDto){
        importService.updateImportById(id, updateTotalAmountImportDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public void updateImportIsDeleteByUuid(@PathVariable String uuid){
        importService.updateImportIsDeleteByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{date}")
    public void updateAllImportIsDeleteByImportDate(@PathVariable LocalDate date){
        importService.updateAllImportIsDeleteByImportDate(date);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteImportByUuid(@PathVariable String uuid){
        importService.deleteImportByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{date}")
    public void deleteAllImportByImportDate(@PathVariable LocalDate date){
        importService.deleteAllImportByImportDate(date);
    }

    @GetMapping
    public List<ImportDto> findAll(){
        return importService.findAll();
    }

    @GetMapping("/{uuid}")
    public ImportDto findByUuid(@PathVariable String uuid){
        return importService.findByUuid(uuid);
    }

    @GetMapping("/date/{date}")
    public List<ImportDto> findAllByImportDate(@PathVariable LocalDate date){
        return importService.findAllByImportDate(date);
    }

    @GetMapping("/is_delete")
    public List<ImportDto> findAllByIsDeleteIsTrue(){
        return importService.findAllByIsDeleteIsTrue();
    }

    @GetMapping("/last_id")
    public Long findLastImportID (){
        return importService.findLastImportId();
    }

}
