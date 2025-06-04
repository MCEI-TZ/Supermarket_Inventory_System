import { Observable } from 'rxjs';
import { Product } from '../models/product.models';

export abstract class ProductRepository {
  abstract getProducts(): Observable<Product[]>;

  abstract getProductById(id: number): Observable<Product>;

  abstract createProduct(product: Product): Observable<Product>;

  abstract updateProduct(id: number, product: Product): Observable<void>;

  abstract deleteProduct(id: number): Observable<void>;
}
