package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Customer;
import com.example.coffeeshop.api.web.customer.CreateCustomerDto;
import com.example.coffeeshop.api.web.customer.CustomerDto;
import com.example.coffeeshop.api.web.customer.UpdateCustomerDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // create new customer

    /**
     *mapping to create customer. "CustomerDto" to "Customer"
     * @param createCustomerDto
     * @return
     */
    Customer formCustomerDto(CreateCustomerDto createCustomerDto);

    // update customer

    /**
     * mapping to update a customer. map by "UpdateCustomerDto" with "Customer" and ignore null value
     * @param customer
     * @param updateCustomerDto
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdateCustomerDto(@MappingTarget Customer customer, UpdateCustomerDto updateCustomerDto);

    // select a customer

    /**
     * mapping to select a customer. map by "Customer" to "CustomerDto"
     * @param customer
     * @return
     */
    CustomerDto toCustomerDto(Customer customer);

    // select all customers

    /**
     * mapping to select all customer. map by list of "Customer" to list of "CustomerDto"
     * @param customers
     * @return
     */
    List<CustomerDto> toCustomerDtoList(List<Customer> customers);

}
