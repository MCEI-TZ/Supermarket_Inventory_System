package services.InventoryMovement.impl;

import models.InventoryMovements;
import org.springframework.stereotype.Service;
import repo.IInventoryMovement;
import services.InventoryMovement.InventoryMovementService;
import services.generic.Impl.GenericServiceIImpl;

@Service
public class InventoryMovementServiceImpl extends GenericServiceIImpl<InventoryMovements, Long, IInventoryMovement> implements InventoryMovementService {
}
