export interface InventoryMovementReadDTO {
  idInventoryMovement: number;
  productName: string;
  branchName: string;
  supplierName: string;
  userName: string;
  movementType: string;
  quantity: number;
  date: Date;
  reason: string;
}
