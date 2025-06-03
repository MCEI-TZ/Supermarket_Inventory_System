package com.mceit_z.Inventory_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @NotEmpty
    @Column(unique = true)
    private String name;

    private String description;
}
