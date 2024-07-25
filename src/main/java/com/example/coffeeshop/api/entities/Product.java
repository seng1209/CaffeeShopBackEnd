package com.example.coffeeshop.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150, nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    @Positive
    private BigDecimal saleUnitPrice;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<SaleDetail> saleDetails;

//    @OneToMany(mappedBy = "product")
//    private Set<OrderDetail> orderDetails;

}
