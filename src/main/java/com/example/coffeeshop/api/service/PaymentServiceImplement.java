package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Customer;
import com.example.coffeeshop.api.entities.Payment;
import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.mapper.PaymentMapper;
import com.example.coffeeshop.api.repository.PaymentRepository;
import com.example.coffeeshop.api.web.payment.CreatePaymentDto;
import com.example.coffeeshop.api.web.payment.PaymentDto;
import com.example.coffeeshop.api.web.payment.UpdatePaidAmountPaymentDto;
import com.example.coffeeshop.api.web.payment.UpdatePaymentDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentServiceImplement implements PaymentService{

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public void createNewPayment(CreatePaymentDto createPaymentDto) {
        Payment payment = paymentMapper.formPaymentDto(createPaymentDto);
        payment.setUuid(UUID.randomUUID().toString());
        payment.setPaymentDate(LocalDate.now());
        payment.setPaidAmount(BigDecimal.valueOf(0));
        payment.setIsDelete(false);
        paymentRepository.save(payment);
    }

    @Override
    public void updatePaymentByUuid(String uuid, UpdatePaymentDto updatePaymentDto) {
        if (paymentRepository.existsByUuid(uuid)){
            Payment payment = paymentRepository.findByUuid(uuid).orElseThrow();
            paymentMapper.formUpdatePaymentDto(payment, updatePaymentDto);

            if (updatePaymentDto.customerId() != null){
                Customer newCustomer = new Customer();
                newCustomer.setId(updatePaymentDto.customerId());
                payment.setCustomer(newCustomer);
            }

            if (updatePaymentDto.staffId() != null){
                Staff newStaff = new Staff();
                newStaff.setId(updatePaymentDto.staffId());
                payment.setStaff(newStaff);
            }

            paymentRepository.save(payment);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Payment by UUID : %s is not found!...", uuid));
    }

    @Override
    public PaymentDto findPaymentByUuid(String uuid) {
        Payment payment = paymentRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Payment by UUID : %s is not found!...", uuid))
        );
        return paymentMapper.toPaymentDto(payment);
    }

    @Override
    public List<PaymentDto> findAll() {
        List<Payment> payments = paymentRepository.findAllByIsDeleteIsFalse();
        return paymentMapper.toPaymentDtoList(payments);
    }

    @Override
    public List<PaymentDto> findPaymentByDate(LocalDate date) {
        List<Payment> payments = paymentRepository.findAllByPaymentDate(date);
        return paymentMapper.toPaymentDtoList(payments);
    }

    @Transactional
    @Override
    public void updatePaymentByIsDelete(String uuid) {
        if (paymentRepository.existsByUuid(uuid)){
            paymentRepository.editPaymentIsDeleteIsTrueByUuid(uuid, true);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Payment by UUID : %s is not found!...", uuid));
    }

    @Transactional
    @Override
    public void updatePaymentByDate(LocalDate date) {
        if (paymentRepository.existsByPaymentDate(date)){
            paymentRepository.editAllPaymentIsDeleteIsTrueByPaymentDate(date);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Payment by Payment Date : %s is not found!...", date));
    }

    @Transactional
    @Override
    public void updatePaidAmountPaymentDto(Long id, UpdatePaidAmountPaymentDto updatePaidAmountPaymentDto) {
        paymentRepository.editPaidAmountByUuid(id, updatePaidAmountPaymentDto.paidAmount());
    }

    @Override
    public PaymentDto findById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Payment at ID : %s not found!", id))
        );
        return paymentMapper.toPaymentDto(payment);
    }

    @Override
    public List<PaymentDto> findAllByCustomer(String customer) {
        List<Payment> payments = paymentRepository.findAllByCustomer(customer);
        return paymentMapper.toPaymentDtoList(payments);
    }

    @Override
    public List<PaymentDto> findAllByStaff(String staff) {
        List<Payment> payments = paymentRepository.findAllByStaff(staff);
        return paymentMapper.toPaymentDtoList(payments);
    }
}
