import { InventoryMovementCreateDTO } from '../../infraestructure/dto/inventory_movement/inventory_movementCreate.dto';
import { InventoryMovementReadDTO } from '../../infraestructure/dto/inventory_movement/inventory_movementRead.dto';
import { InventoryMovement } from '../models/inventory_movement.model';
import { ProductStock } from '../models/product_stock.model';
import { User } from '../models/user.model';

export class InventoryMovementMapper {
  static fromApiToDomain(
    apiInventoryMovement: InventoryMovementReadDTO
  ): InventoryMovement {
    return {
      idInventoryMovement: apiInventoryMovement.idInventoryMovement,
      productStock: {
        product: { name: apiInventoryMovement.productName },
        branch: { name: apiInventoryMovement.branchName },
        supplier: { name: apiInventoryMovement.supplierName },
      } as ProductStock,
      user: {
        username: apiInventoryMovement.userName,
      } as User,
      movementType: apiInventoryMovement.movementType,
      quantity: apiInventoryMovement.quantity,
      date: apiInventoryMovement.date,
      reason: apiInventoryMovement.reason,
    };
  }

  static fromDomainToApi(
    inventoryMovement: InventoryMovement
  ): InventoryMovementCreateDTO {
    return {
      idProductStock: inventoryMovement.productStock.idProductStock,
      idUser: inventoryMovement.user.idUser,
      movementType: inventoryMovement.movementType,
      quantity: inventoryMovement.quantity,
      date: inventoryMovement.date,
      reason: inventoryMovement.reason,
    };
  }
}
