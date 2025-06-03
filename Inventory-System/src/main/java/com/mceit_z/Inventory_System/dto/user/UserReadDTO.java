package com.mceit_z.Inventory_System.dto.user;

import com.mceit_z.Inventory_System.models.Branch;
import com.mceit_z.Inventory_System.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReadDTO {
    private Long idUser;

    private String username;

    private String password;

    private String email;

    private String fullName;

    private String rolName;

    private String branchName;
}
