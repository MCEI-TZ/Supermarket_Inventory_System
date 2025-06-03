package com.mceit_z.Inventory_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier")
    private Long idSupplier;

    @NotEmpty
    private String name;

    private String contactName;

    @Email
    private String email;

    private String phone;

    private String address;
}
