package com.mceit_z.Inventory_System.dto.product;

import com.mceit_z.Inventory_System.models.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO {

    private String name;

    private String description;

    private String barcode;

    private Date expirationDate;

    private Long categoryId;
}
