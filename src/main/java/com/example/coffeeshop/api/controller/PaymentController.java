package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.PaymentService;
import com.example.coffeeshop.api.web.payment.CreatePaymentDto;
import com.example.coffeeshop.api.web.payment.PaymentDto;
import com.example.coffeeshop.api.web.payment.UpdatePaymentDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewPayment(@RequestBody @Valid CreatePaymentDto createPaymentDto){
        paymentService.createNewPayment(createPaymentDto);
    }

    @GetMapping
    public List<PaymentDto> findAll(){
        return paymentService.findAll();
    }

    @GetMapping("/{uuid}")
    public PaymentDto findByUuid(@PathVariable String uuid){
        return paymentService.findPaymentByUuid(uuid);
    }

    @GetMapping("/date/{date}")
    public List<PaymentDto> findByDate(@PathVariable LocalDate date){
        return paymentService.findPaymentByDate(date);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public void deletePaymentByUuid(@PathVariable String uuid){
        paymentService.updatePaymentByIsDelete(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/date/{date}")
    public void deleteAllPaymentByDate(@PathVariable LocalDate date){
        paymentService.updatePaymentByDate(date);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updatePaymentByUuid(@PathVariable String uuid, @RequestBody @Valid UpdatePaymentDto updatePaymentDto){
        paymentService.updatePaymentByUuid(uuid, updatePaymentDto);
    }

}
