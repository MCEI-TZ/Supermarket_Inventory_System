package com.mceit_z.Inventory_System.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDTO {
    private String name;

    private String descripcion;
}
