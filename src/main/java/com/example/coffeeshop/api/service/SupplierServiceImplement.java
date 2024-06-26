package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Supplier;
import com.example.coffeeshop.api.mapper.SupplierMapper;
import com.example.coffeeshop.api.repository.SupplierRepository;
import com.example.coffeeshop.api.web.supllier.CreateSupplierDto;
import com.example.coffeeshop.api.web.supllier.SupplierDto;
import com.example.coffeeshop.api.web.supllier.UpdateSupplierDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierServiceImplement implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public void createNewSupplier(CreateSupplierDto createSupplierDto) {
        Supplier supplier = supplierMapper.formSupplierDto(createSupplierDto);
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplierByContactPhone(String contactPhone, UpdateSupplierDto updateSupplierDto) {
        if (supplierRepository.existsByContactPhone(contactPhone)){
            Supplier supplier = supplierRepository.findByContactPhone(contactPhone).orElseThrow();
            supplierMapper.formUpdateSupplierDto(supplier, updateSupplierDto);
            supplierRepository.save(supplier);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Supplier phone : %s is not found", contactPhone));

    }

    @Override
    public void deleteSupplierByContactPhone(String phone) {
        Supplier supplier = supplierRepository.findByContactPhone(phone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Supplier phone : %s is not found", phone))
        );
        supplierRepository.delete(supplier);
    }

    @Override
    public SupplierDto findSupplierByContactPhone(String contactPhone) {
        Supplier supplier = supplierRepository.findByContactPhone(contactPhone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Supplier phone : %s is not found", contactPhone))
        );
        return supplierMapper.toSupplierDto(supplier);
    }

    @Override
    public List<SupplierDto> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return supplierMapper.toSupplierDtoList(suppliers);
    }

    @Override
    public SupplierDto searchSupplierByContactPhone(String contactPhone) {
        Supplier supplier = supplierRepository.findByContactPhone(contactPhone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Supplier phone : %s is not found", contactPhone))
        );
        return supplierMapper.toSupplierDto(supplier);
    }

    @Override
    public SupplierDto searchSupplierByContactAddress(String contactAddress) {
        Supplier supplier = supplierRepository.findByContactAddress(contactAddress).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Supplier address : %s is not found", contactAddress))
        );
        return supplierMapper.toSupplierDto(supplier);
    }

    @Override
    public SupplierDto searchSupplierByContactPhoneAndContactAddress(String contactPhone, String contactAddress) {
        Supplier supplier = supplierRepository.findByContactPhoneAndContactAddress(contactPhone, contactAddress).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Supplier at Contact Phone : %s And Contact Address : %s is not found!", contactPhone, contactAddress))
        );
        return supplierMapper.toSupplierDto(supplier);
    }
}
