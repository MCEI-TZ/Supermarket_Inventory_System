import { SupplierCreateDTO } from '../../infraestructure/dto/supplier/supplierCreate.dto';
import { SupplierReadDTO } from '../../infraestructure/dto/supplier/supplierRead.dto';
import { Supplier } from '../models/supplier.model';

export class SupplierMapper {
  static fromApiToDomain(apiSupplier: SupplierReadDTO): Supplier {
    return {
      idSupplier: apiSupplier.idSupplier,
      contactName: apiSupplier.contactName,
      email: apiSupplier.email,
      name: apiSupplier.name,
      phone: apiSupplier.phone,
    };
  }

  static fromDomainToApi(supplier: Supplier): SupplierCreateDTO {
    return {
      contactName: supplier.contactName,
      email: supplier.email,
      name: supplier.name,
      phone: supplier.phone,
    };
  }
}
