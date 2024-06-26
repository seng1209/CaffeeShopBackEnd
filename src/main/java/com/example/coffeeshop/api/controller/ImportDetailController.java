package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.ImportDetailService;
import com.example.coffeeshop.api.web.import_detail.CreateImportDetail;
import com.example.coffeeshop.api.web.import_detail.ImportDetailDto;
import com.example.coffeeshop.api.web.import_detail.UpdateImportDetail;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v2/import_detail")
@AllArgsConstructor
public class ImportDetailController {

    private final ImportDetailService importDetailService;

    @PostMapping
    public void createNewImportDetail(@RequestBody @Valid CreateImportDetail createImportDetail){
        importDetailService.createNewImportDetail(createImportDetail);
    }

    @PatchMapping("/{uuid}")
    public void updateByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateImportDetail updateImportDetail){
        importDetailService.updateByUuid(uuid,updateImportDetail);
    }

    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid){
        importDetailService.deleteByUuid(uuid);
    }

    @GetMapping("/{uuid}")
    ImportDetailDto findByUuid(@PathVariable String uuid){
        return importDetailService.findByUuid(uuid);
    }

    @GetMapping
    public List<ImportDetailDto> findAll(){
        return importDetailService.findAll();
    }

    @GetMapping("/total_amount/{importsId}")
    public BigDecimal getTotalAmount(@PathVariable Long importsId){
        return importDetailService.getTotalAmount(importsId);
    }

    @GetMapping("/import_id/{importId}")
    public List<ImportDetailDto> findAllImportDetailByImportId(@PathVariable Long importId){
        return importDetailService.findAllImportDetailByImportId(importId);
    }

    @GetMapping("/import_uuid/{uuid}")
    public List<ImportDetailDto> findAllImportDetailByImportUuid(@PathVariable String uuid){
        return importDetailService.findAllImportDetailByImportUuid(uuid);
    }

}
