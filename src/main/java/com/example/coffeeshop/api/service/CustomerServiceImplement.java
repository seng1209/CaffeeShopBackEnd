package com.example.coffeeshop.api.service;


import com.example.coffeeshop.api.entities.Customer;
import com.example.coffeeshop.api.mapper.CustomerMapper;
import com.example.coffeeshop.api.repository.CustomerRepository;
import com.example.coffeeshop.api.web.customer.CreateCustomerDto;
import com.example.coffeeshop.api.web.customer.CustomerDto;
import com.example.coffeeshop.api.web.customer.UpdateCustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService{

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public void createNewCustomer(CreateCustomerDto createCustomerDto) {
        if (!customerRepository.existsByPhone(createCustomerDto.phone())){
            Customer customer = customerMapper.formCustomerDto(createCustomerDto);
            customerRepository.save(customer);
            return;
        }

        throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED,
                String.format("Customer phone : %s is already exists!....",createCustomerDto.phone()));
    }

    @Override
    public void updateCustomerByPhone(String phone, UpdateCustomerDto updateCustomerDto) {
        if(customerRepository.existsByPhone(phone)){
            Customer customer = customerRepository.findByPhone(phone).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            String.format("Customer at the phone : %s is not found!...", phone))
            );
            customerMapper.formUpdateCustomerDto(customer, updateCustomerDto);
            customerRepository.save(customer);
        }
    }

    @Override
    public void deleteCustomerByPhone(String phone) {
        Customer customer = customerRepository.findByPhone(phone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Customer at the phone : %s is not found!...", phone))
        );
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDto findCustomerByPhone(String phone) {
        Customer customer = customerRepository.findByPhone(phone).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Customer at the phone : %s is not found!...", phone))
        );
        return customerMapper.toCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toCustomerDtoList(customers);
    }

    @Override
    public List<CustomerDto> searchCustomer(String name, String phone) {
        List<Customer> customers = customerRepository.findAllByNameOrPhone(name, phone);
        return customerMapper.toCustomerDtoList(customers);
    }
}
