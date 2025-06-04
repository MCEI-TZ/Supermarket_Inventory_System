import { Category } from './category.model';

export class Product {
  constructor(
    public idProduct: number,
    public name: string,
    public description: string,
    public barcode: string,
    public expirationDate: Date,
    public category: Category
  ) {}
}
