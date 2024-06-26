package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Payment;
import com.example.coffeeshop.api.web.payment.CreatePaymentDto;
import com.example.coffeeshop.api.web.payment.PaymentDto;
import com.example.coffeeshop.api.web.payment.UpdatePaymentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    // create payment
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "staffId", target = "staff.id")
    Payment formPaymentDto(CreatePaymentDto createPaymentDto);

    // update payment
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void formUpdatePaymentDto(@MappingTarget Payment payment, UpdatePaymentDto updatePaymentDto);

    // select a payment
    @Mapping(source = "customer.name", target = "customer")
    @Mapping(source = "staff.name", target = "staff")
    PaymentDto toPaymentDto(Payment payment);

    // select all payment
    List<PaymentDto> toPaymentDtoList(List<Payment> payments);

}
