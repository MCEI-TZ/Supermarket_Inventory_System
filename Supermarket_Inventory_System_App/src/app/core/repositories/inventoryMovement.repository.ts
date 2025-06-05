import { InventoryMovement } from './../models/inventory_movement.model';
import { Observable } from 'rxjs';

export abstract class InventoryMovementRepository {
  abstract getInventoryMovements(): Observable<InventoryMovement[]>;
  abstract getInventoryMovementById(): Observable<InventoryMovement>;
  abstract createInventoryMovement(createInventory: InventoryMovement): Observable<InventoryMovement>;
  abstract updateInventoryMovement(id: number,updateInventory: InventoryMovement): Observable<void>;
  abstract deleteInventoryMovement(id: number): Observable<void>;
}
