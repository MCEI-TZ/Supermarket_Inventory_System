package com.mceit_z.Inventory_System.dto.branch;

import com.mceit_z.Inventory_System.models.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchUpdateDTO {
    private Long idBranch;

    private String name;

    private String address;

    private String city;

    private String region;
}
