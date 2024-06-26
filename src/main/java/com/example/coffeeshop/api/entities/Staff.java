package com.example.coffeeshop.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "staffs")
@Setter
@Getter
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 6, nullable = false)
    private String gender;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(length = 20, nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(length = 150)
    private String position;
    @Column(nullable = false)
    @Positive
    private BigDecimal salary;
    @Column(nullable = false)
    private LocalDate hiredDate;
    @Column(nullable = false)
    private Boolean stopWork;

}
