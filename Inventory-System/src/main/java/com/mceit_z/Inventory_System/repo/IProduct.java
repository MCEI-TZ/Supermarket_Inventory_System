package com.mceit_z.Inventory_System.repo;

import com.mceit_z.Inventory_System.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduct extends JpaRepository<Product,Long> {
}
