package com.example.coffeeshop.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "import_detail")
@Setter
@Getter
@NoArgsConstructor
public class ImportDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String uuid;
    @ManyToOne
    @JoinColumn(name = "import_id")
    private Import imports;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item items;
    @Column(nullable = false)
    private Integer importQty;
    @Column(nullable = false)
    private BigDecimal unitPrice;
    @Column(nullable = false)
    private BigDecimal amount;
}
