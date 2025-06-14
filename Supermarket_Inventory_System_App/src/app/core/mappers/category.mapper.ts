import { CategoryCreateDTO } from '../../infraestructure/dto/category/categoryCreate.dto';
import { CategoryReadDTO } from '../../infraestructure/dto/category/categoryRead.dto';
import { Category } from '../models/category.model';

export class CategoryMapper {
  static fromApiToDomain(apiCategory: CategoryReadDTO): Category {
    return {
      idCategory: apiCategory.idCategory,
      name: apiCategory.name,
      description: apiCategory.description,
    };
  }

  static fromDomainToApi(category: Category): CategoryCreateDTO {
    return {
      name: category.name,
      description: category.description,
    };
  }
}
