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
public class ProductStockUpdateDTO {
    private Long idProductStock;
    private Long productId;
    private Long branchId;
    private Long supplierId;
    private int quantity;
    private double price;
    private Date lastRestockDate;
}
