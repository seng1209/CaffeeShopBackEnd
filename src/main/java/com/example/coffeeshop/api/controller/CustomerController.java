package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.CustomerService;
import com.example.coffeeshop.api.web.customer.CreateCustomerDto;
import com.example.coffeeshop.api.web.customer.CustomerDto;
import com.example.coffeeshop.api.web.customer.UpdateCustomerDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/customers")
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewCustomer(@RequestBody @Valid CreateCustomerDto createCustomerDto){
        customerService.createNewCustomer(createCustomerDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{phone}")
    public void updateCustomerByPhone(@PathVariable String phone, @RequestBody @Valid UpdateCustomerDto updateCustomerDto){
        customerService.updateCustomerByPhone(phone, updateCustomerDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{phone}")
    public void deleteCustomerByPhone(@PathVariable String phone){
        customerService.deleteCustomerByPhone(phone);
    }

    @GetMapping
    public List<CustomerDto> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{phone}")
    public CustomerDto findCustomerByPhone(@PathVariable String phone){
        return customerService.findCustomerByPhone(phone);
    }

    @GetMapping("/search")
    public List<CustomerDto> searchCustomer(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String phone
    )
    {
        return customerService.searchCustomer(name, phone);
    }

}
