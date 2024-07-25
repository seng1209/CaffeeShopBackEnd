package com.example.coffeeshop.api.web.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDto(
        @JsonIgnore
        Long id,
        String uuid,
        LocalDate paymentDate,
        @JsonIgnore
        Integer customerId,
        String customer,
        @JsonIgnore
        Integer staffId,
        String staff,
        BigDecimal paidAmount,
        Boolean isDelete) {

        public Long getId(){
                return this.id();
        }

        public Integer getCustomerId(){
                return this.customerId();
        }

        public Integer getStaffId(){
                return this.staffId();
        }
}
