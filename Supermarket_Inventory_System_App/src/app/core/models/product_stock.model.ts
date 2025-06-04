import { Branch } from './branch.model';
import { Product } from './product.models';
import { Supplier } from './supplier.model';

export class ProductStock {
  constructor(
    idProductStock: number,
    product: Product,
    branch: Branch,
    supplier: Supplier,
    quantity: number,
    price: number,
    lastRestockDate: Date
  ) {}
}
