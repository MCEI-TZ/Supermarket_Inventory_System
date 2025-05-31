package com.mceit_z.Inventory_System.services.InventoryMovement.impl;

import com.mceit_z.Inventory_System.models.InventoryMovements;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.repo.IInventoryMovement;
import com.mceit_z.Inventory_System.services.InventoryMovement.InventoryMovementService;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;

@Service
public class InventoryMovementServiceImpl extends GenericServiceIImpl<InventoryMovements, Long, IInventoryMovement> implements InventoryMovementService {
}
