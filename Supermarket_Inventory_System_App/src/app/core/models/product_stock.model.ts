import { Branch } from './branch.model';
import { Product } from './product.models';
import { Supplier } from './supplier.model';

export class ProductStock {
  constructor(
    public idProductStock: number,
    public product: Product,
    public branch: Branch,
    public supplier: Supplier,
    public quantity: number,
    public price: number,
    public lastRestockDate: Date
  ) {}
}
