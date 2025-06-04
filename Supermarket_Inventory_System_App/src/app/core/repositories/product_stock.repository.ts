import { Observable } from "rxjs";
import { ProductStock } from "../models/product_stock.model";

export abstract class ProductStockRepository {
  abstract getProductStocks(): Observable<ProductStock[]>;

  abstract getProductStockById(id: number): Observable<ProductStock>;

  abstract createProductStock(productStock: ProductStock): Observable<ProductStock>;

  abstract updateProductStock(id: number, productStock: ProductStock): Observable<void>;

  abstract deleteProductStock(id: number): Observable<void>;
}
