import { ProductStockCreateDTO } from '../../infraestructure/dto/product_stock/product_stockCreate.dto';
import { ProductStockReadDTO } from '../../infraestructure/dto/product_stock/product_stockRead.dto';
import { Branch } from '../models/branch.model';
import { Product } from '../models/product.models';
import { ProductStock } from '../models/product_stock.model';
import { Supplier } from '../models/supplier.model';

export class ProductStockMapper {
  static fromApiToDomain(apiProductStock: ProductStockReadDTO): ProductStock {
    return {
      idProductStock: apiProductStock.idProductStock,
      product: { name: apiProductStock.productName } as Product,
      branch: { name: apiProductStock.branchName } as Branch,
      supplier: { name: apiProductStock.supplierName } as Supplier,
      quantity: apiProductStock.quantity,
      lastRestockDate: apiProductStock.lastRestockDate,
      price: apiProductStock.price,
    };
  }

  static fromDomainToApi(productStock: ProductStock): ProductStockCreateDTO {
    return {
      IdBranch: productStock.branch.idBranch,
      IdProduct: productStock.product.idProduct,
      IdSupplier: productStock.supplier.idSupplier,
      lastRestockDate: productStock.lastRestockDate,
      price: productStock.price,
      quantity: productStock.quantity,
    };
  }
}
