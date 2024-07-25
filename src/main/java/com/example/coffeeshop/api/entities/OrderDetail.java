//package com.example.coffeeshop.api.entities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "order_detail")
//@Setter
//@Getter
//@NoArgsConstructor
//public class OrderDetail {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false, unique = true)
//    private String uuid;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//    @Column(nullable = false)
//    private BigDecimal unitPrice;
//    @Column(nullable = false)
//    private Integer quantity;
////    @Column(nullable = false)
////    private BigDecimal amount;
//
//}
