package com.mceit_z.Inventory_System.repo;

import com.mceit_z.Inventory_System.models.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductStock extends JpaRepository<ProductStock,Long> {
}
