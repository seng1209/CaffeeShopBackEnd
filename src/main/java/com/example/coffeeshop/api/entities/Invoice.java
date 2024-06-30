package com.example.coffeeshop.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoces")
@Setter
@Getter
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private LocalDate invoiceDate;
    @Column(nullable = false)
//    @Positive
    private BigDecimal totalAmount;
//    @Column(nullable = false)
//    @Positive
//    private BigDecimal paidAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private Boolean isDelete;

}
