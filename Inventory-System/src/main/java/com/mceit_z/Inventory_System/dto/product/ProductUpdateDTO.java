package com.mceit_z.Inventory_System.dto.product;

import com.mceit_z.Inventory_System.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDTO {
    private Long idProduct;

    private String name;

    private String description;

    private String barcode;

    private Date expirationDate;

    private Long categoryId;
}
