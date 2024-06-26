package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.payment.CreatePaymentDto;
import com.example.coffeeshop.api.web.payment.PaymentDto;
import com.example.coffeeshop.api.web.payment.UpdatePaymentDto;

import java.time.LocalDate;
import java.util.List;

public interface PaymentService {

    // create payment
    void createNewPayment(CreatePaymentDto createPaymentDto);

    // update payment by uuid
    void updatePaymentByUuid(String uuid, UpdatePaymentDto updatePaymentDto);

    // select a payment by uuid
    PaymentDto findPaymentByUuid(String uuid);

    // select all payment
    List<PaymentDto> findAll();

    // select all payment by date
    List<PaymentDto> findPaymentByDate(LocalDate date);

    // update a payment by isDelete
    void updatePaymentByIsDelete(String uuid);

    // update all payment by isDelete
    void updatePaymentByDate(LocalDate date);

}
