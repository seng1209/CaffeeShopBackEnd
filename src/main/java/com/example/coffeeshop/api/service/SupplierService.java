package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.supllier.CreateSupplierDto;
import com.example.coffeeshop.api.web.supllier.SupplierDto;
import com.example.coffeeshop.api.web.supllier.UpdateSupplierDto;

import java.util.List;

public interface SupplierService {

    // create supplier
    void createNewSupplier(CreateSupplierDto createSupplierDto);

    // update supplier by contact phone
    void updateSupplierByContactPhone(String contactPhone, UpdateSupplierDto updateSupplierDto);

    // delete supplier by phone
    void deleteSupplierByContactPhone(String phone);

    // select supplier by contact phone
    SupplierDto findSupplierByContactPhone(String contactPhone);

    // select all supplier
    List<SupplierDto> findAll();

    // search by contact phone
    SupplierDto searchSupplierByContactPhone(String contactPhone);

    // search by contact address
    SupplierDto searchSupplierByContactAddress(String contactAddress);

    // search by contact phone and contact address
    SupplierDto searchSupplierByContactPhoneAndContactAddress(String contactPhone, String contactAddress);

    SupplierDto findById(Integer id);

    List<SupplierDto> findAllByName(String name);

    List<SupplierDto> findByPhoneNumber(String phone);

}
