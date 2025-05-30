package com.mceit_z.Inventory_System.repo;

import com.mceit_z.Inventory_System.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplier extends JpaRepository<Supplier,Long> {
}
