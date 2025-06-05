export interface InventoryMovementCreateDTO {
  idProductStock: number;
  idUser: number;
  movementType: string;
  quantity: number;
  date: Date;
  reason: string;
}
