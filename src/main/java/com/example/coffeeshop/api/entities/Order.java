//package com.example.coffeeshop.api.entities;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Positive;
//import jdk.jfr.Enabled;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//@Entity
//@Table(name = "orders")
//@Setter
//@Getter
//@NoArgsConstructor
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false)
//    private String uuid;
//    private LocalDate orderDate;
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//    @ManyToOne
//    @JoinColumn(name = "payment_id")
//    private Payment payment;
//    @ManyToOne
//    @JoinColumn(name = "delivery_id")
//    private Delivery delivery;
////    @Positive
//    private Integer quantity = 0;
//
//    @OneToMany(mappedBy = "order")
//    private Set<OrderDetail> orderDetails;
//
//    @Column(nullable = false)
//    private Boolean isDelete;
//
//}
