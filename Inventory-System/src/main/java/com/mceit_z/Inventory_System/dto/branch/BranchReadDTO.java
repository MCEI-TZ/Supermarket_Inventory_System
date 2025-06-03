package com.mceit_z.Inventory_System.dto.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchReadDTO {
    private Long idBranch;

    private String name;

    private String address;

    private String city;

    private String region;
}
