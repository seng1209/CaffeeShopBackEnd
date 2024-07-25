package com.example.coffeeshop.api.web.sale;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SaleDto(
        @JsonIgnore
        Long id,
        String uuid,
        LocalDate saleDate,
        @JsonIgnore
        Integer customerId,
        String customer,
        @JsonIgnore
        Integer staffId,
        String staff,
        @JsonIgnore
        Long paymentId,
        String paymentUuid,
        @JsonIgnore
        Long deliveryId,
        BigDecimal totalAmount
) {

    public Long getId(){
        return this.id();
    }

    public Integer getCustomerId(){
        return this.customerId();
    }

    public Integer getStaffId(){
        return this.staffId();
    }

    public Long getPaymentId(){
        return this.paymentId();
    }

    public Long getDeliveryId() {
        return this.deliveryId();
    }
}
