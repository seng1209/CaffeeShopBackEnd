package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.SupplierService;
import com.example.coffeeshop.api.web.supllier.CreateSupplierDto;
import com.example.coffeeshop.api.web.supllier.SupplierDto;
import com.example.coffeeshop.api.web.supllier.UpdateSupplierDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/suppliers")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewSupplier(@RequestBody @Valid CreateSupplierDto createSupplierDto){
        supplierService.createNewSupplier(createSupplierDto);
    }

    @GetMapping
    public List<SupplierDto> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{contactPhone}")
    public SupplierDto findSupplierByContactPhone(@PathVariable String contactPhone){
        return supplierService.findSupplierByContactPhone(contactPhone);
    }

    /*@GetMapping("/search")
    public SupplierDto searchSupplierByContactAddress(@RequestParam(required = false, defaultValue = "") String contactAddress){
        return supplierService.searchSupplierByContactAddress(contactAddress);
    }*/

    /*@GetMapping("/search")
    public SupplierDto searchSupplierByContactPhone(@RequestParam(required = false, defaultValue = "") String contactPhone){
        return supplierService.searchSupplierByContactPhone(contactPhone);
    }*/

    @GetMapping("/search")
    public SupplierDto searchSupplierByContactPhoneAndContactAddress(
            @RequestParam(required = false, defaultValue = "") String contactPhone,
            @RequestParam(required = false, defaultValue = "") String contactAddress
    )
    {
        return supplierService.searchSupplierByContactPhoneAndContactAddress(contactPhone, contactAddress);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{contactPhone}")
    public void updateSupplierByContactPhone(@PathVariable String contactPhone, @RequestBody @Valid UpdateSupplierDto updateSupplierDto){
        supplierService.updateSupplierByContactPhone(contactPhone, updateSupplierDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{phone}")
    public void deleteSupplierByContactPhone(@PathVariable String phone){
        supplierService.deleteSupplierByContactPhone(phone);
    }

}
