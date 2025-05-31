package com.mceit_z.Inventory_System.repo;

import com.mceit_z.Inventory_System.models.InventoryMovements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryMovement extends JpaRepository<InventoryMovements,Long> {
}
