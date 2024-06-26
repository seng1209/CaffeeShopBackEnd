package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.customer.CreateCustomerDto;
import com.example.coffeeshop.api.web.customer.CustomerDto;
import com.example.coffeeshop.api.web.customer.UpdateCustomerDto;

import java.util.List;

public interface CustomerService {

    // create customer
    void createNewCustomer(CreateCustomerDto createCustomerDto);

    // update customer by phone
    void updateCustomerByPhone(String phone, UpdateCustomerDto updateCustomerDto);

    // delete customer by phone
    void deleteCustomerByPhone(String phone);

    // select customer by phone
    CustomerDto findCustomerByPhone(String phone);

    // select all customers
    List<CustomerDto> findAll();

    // search
    List<CustomerDto> searchCustomer(String name, String phone);

}
