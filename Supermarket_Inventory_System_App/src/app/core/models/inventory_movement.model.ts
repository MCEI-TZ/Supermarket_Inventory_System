import { ProductStock } from './product_stock.model';
import { User } from './user.model';

export class InventoryMovement {
  constructor(
    public idInventoryMovement: number,
    public productStock: ProductStock,
    public user: User,
    public movementType: string,
    public quantity: number,
    public date: Date,
    public reason: string
  ) {}
}
