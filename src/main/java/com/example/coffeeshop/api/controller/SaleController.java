package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.SaleService;
import com.example.coffeeshop.api.web.sale.CreateSaleDto;
import com.example.coffeeshop.api.web.sale.SaleDto;
import com.example.coffeeshop.api.web.sale.UpdateSaleDto;
import com.example.coffeeshop.api.web.sale.UpdateTotalAmountSaleDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/sales")
@AllArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewSale(@RequestBody @Valid CreateSaleDto createSaleDto){
        saleService.createNewSale(createSaleDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateSaleByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateSaleDto updateSaleDto){
        saleService.updateSaleByUuid(uuid, updateSaleDto);
    }

    @PutMapping("/{saleId}")
    public void updateTotalAmountBySaleId(@PathVariable Long saleId, @RequestBody @Valid UpdateTotalAmountSaleDto updateTotalAmountSaleDto){
        saleService.updateTotalAmountBySaleId(saleId, updateTotalAmountSaleDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteSaleByUuid(@PathVariable String uuid){
        saleService.deleteSaleByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/date/{date}")
    public void deleteAllSaleBySaleDate(@PathVariable LocalDate date){
        saleService.deleteAllSaleBySaleDate(date);
    }

    @GetMapping("/{uuid}")
    public SaleDto findByUuid(@PathVariable String uuid){
        return saleService.findByUuid(uuid);
    }

    @GetMapping
    public List<SaleDto> findAll(){
        return saleService.findALl();
    }

    @GetMapping("/last_id")
    public Long getLastSaleId(){
        return saleService.getLastSaleId();
    }

}
