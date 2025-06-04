import { Observable } from 'rxjs';
import { Supplier } from '../models/supplier.model';

export abstract class SupplierRepository {
  abstract getSuppliers(): Observable<Supplier[]>;
  abstract getSupplierById(id: number): Observable<Supplier>;
  abstract createSupplier(supplier: Supplier): Observable<Supplier>;
  abstract updateSupplier(id: number, supplier: Supplier): Observable<void>;
  abstract deleteSupplier(id: number): Observable<void>;
}
