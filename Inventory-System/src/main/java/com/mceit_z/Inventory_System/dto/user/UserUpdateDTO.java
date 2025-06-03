package com.mceit_z.Inventory_System.dto.user;

import com.mceit_z.Inventory_System.models.Branch;
import com.mceit_z.Inventory_System.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
    private Long idUser;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private Long rolId;

    private Long branchId;
}
