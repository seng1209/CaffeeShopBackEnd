//package com.example.coffeeshop.api.web.order;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.time.LocalDate;
//
//public record OrderDto(
//        @JsonIgnore
//        Long id,
//        String uuid,
//        LocalDate orderDate,
//        @JsonIgnore
//        Integer customerId,
//        String customer,
//        @JsonIgnore
//        Long paymentId,
//        @JsonIgnore
//        Long deliveryId,
//        Integer quantity,
//        Boolean isDelete
//) {
//
//        public Long getId(){
//                return this.id();
//        }
//
//        public Integer getCustomerId(){
//                return this.customerId();
//        }
//
//        public Long getPaymentId(){
//                return this.paymentId();
//        }
//
//        public Long getDeliveryId(){
//                return this.deliveryId();
//        }
//}
