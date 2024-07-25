package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.SaleDetailService;
import com.example.coffeeshop.api.web.sale_detail.CreateSaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.SaleDetailDto;
import com.example.coffeeshop.api.web.sale_detail.UpdateSaleDetailDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/sale_detail")
@AllArgsConstructor
public class SaleDetailController {

    private final SaleDetailService saleDetailService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewSaleDetail(@RequestBody @Valid CreateSaleDetailDto createSaleDetailDto){
        saleDetailService.createNewSaleDetail(createSaleDetailDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateSaleDetailDto updateSaleDetailDto){
        saleDetailService.updateByUuid(uuid, updateSaleDetailDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid){
        saleDetailService.deleteByUuid(uuid);
    }

    @GetMapping("/{uuid}")
    public SaleDetailDto findByUuid(@PathVariable String uuid){
        return saleDetailService.findByUuid(uuid);
    }

    @GetMapping
    public List<SaleDetailDto> findAll(){
        return saleDetailService.findAll();
    }

    @GetMapping("/total_amount/{saleId}")
    public BigDecimal getAllAmountBySaleId(@PathVariable Long saleId){
        return saleDetailService.getAllAmountBySaleId(saleId);
    }

    @GetMapping("/total_amount/date/{saleDate}")
    public BigDecimal getAmountBySaleDate(@PathVariable LocalDate saleDate){
        return saleDetailService.getAmountBySaleDate(saleDate);
    }

    @GetMapping("/total_amount/between_date/{firstDate}/{lastDate}")
    public BigDecimal getAmountBetweenDate(@PathVariable LocalDate firstDate, @PathVariable LocalDate lastDate){
        return saleDetailService.getAmountBetweenDate(firstDate, lastDate);
    }

    @GetMapping("/sale_uuid/{uuid}")
    public List<SaleDetailDto> findAllSaleDetailBySaleUuid(@PathVariable String uuid){
        return saleDetailService.findAllSaleDetailBySaleUuid(uuid);
    }

    @GetMapping("/sale_id/{saleId}")
    public List<SaleDetailDto> findAllSaleDetailBySaleId(@PathVariable Long saleId){
        return saleDetailService.findAllSaleDetailBySaleId(saleId);
    }

    @GetMapping("/sale_date/{saleDate}")
    public List<SaleDetailDto> findAllSaleDetailBySaleDate(@PathVariable LocalDate saleDate){
        return saleDetailService.findAllSaleDetailBySaleDate(saleDate);
    }

    @GetMapping("/sale_date/between_date/{firstDate}/{lastDate}")
    public List<SaleDetailDto> findAllSaleDetailBetweenSaleDate(@PathVariable LocalDate firstDate, @PathVariable LocalDate lastDate){
        return saleDetailService.findAllSaleDetailBetweenSaleDate(firstDate, lastDate);
    }

}
