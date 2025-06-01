package com.mceit_z.Inventory_System.dto.branch;

import com.mceit_z.Inventory_System.models.UserProfile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchCreateDTO {
    private String name;

    private String address;

    private String city;

    private String region;

    private List<UserProfile> users;
}
