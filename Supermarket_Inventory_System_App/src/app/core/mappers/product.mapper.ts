import { ProductCreateDTO } from '../../infraestructure/dto/product/productCreate.dto';
import { ProductReadDTO } from '../../infraestructure/dto/product/productRead.dto';
import { Category } from '../models/category.model';
import { Product } from '../models/product.models';

export class ProductMapper {
  static fromApiToDomain(apiProduct: ProductReadDTO): Product {
    return {
      idProduct: apiProduct.idProduct,
      name: apiProduct.name,
      description: apiProduct.description,
      barcode: apiProduct.barcode,
      expirationDate: apiProduct.expirationDate,
      category: { name: apiProduct.categoryName } as Category,
    };
  }

  static fromDomainToApi(product: Product): ProductCreateDTO {
    return {
      name: product.name,
      barcode: product.barcode,
      expirationDate: product.expirationDate,
      description: product.description,
      idCategory: product.category.idCategory,
    };
  }
}
