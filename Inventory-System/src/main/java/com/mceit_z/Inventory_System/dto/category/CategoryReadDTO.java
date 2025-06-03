package com.mceit_z.Inventory_System.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReadDTO {
    private Long idCategory;
    private String name;
    private String description;
}
