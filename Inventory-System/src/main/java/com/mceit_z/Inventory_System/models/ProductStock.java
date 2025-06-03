package com.mceit_z.Inventory_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ProductStock implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_stock")
    private Long idProductStock;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_branch")
    private Branch branch;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    private int quantity;

    private double price;

    private Date lastRestockDate;
}
