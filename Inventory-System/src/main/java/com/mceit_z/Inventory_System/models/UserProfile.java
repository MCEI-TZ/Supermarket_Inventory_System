package com.mceit_z.Inventory_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    private String username;

    @NotEmpty
    private String password;

    @Column(unique = true)
    private String email;

    private String fullName;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    @NotNull
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_branch")
    @NotNull
    private Branch branch;

}
