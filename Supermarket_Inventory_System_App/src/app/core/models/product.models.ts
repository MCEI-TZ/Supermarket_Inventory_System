import { Category } from './category.model';

export class Product {
  constructor(
    public idProduct: number,
    public name: string,
    public barcode: string,
    public expirationDate: Date,
    public category: Category,
    public description?: string,
  ) {}
}
