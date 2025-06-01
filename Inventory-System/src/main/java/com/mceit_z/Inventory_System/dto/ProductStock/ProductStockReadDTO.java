package com.mceit_z.Inventory_System.dto.ProductStock;

import com.mceit_z.Inventory_System.models.Branch;
import com.mceit_z.Inventory_System.models.Product;
import com.mceit_z.Inventory_System.models.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockReadDTO {
    private Product product;
    private Branch branch;
    private Supplier supplier;
    private int quantity;
    private Integer stock;
    private double price;
    private Date lastRestockDate;
}
