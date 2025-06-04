import { Observable } from 'rxjs';
import { Category } from '../models/category.model';

export abstract class CategoryRepository {
  abstract getCategories(): Observable<Category[]>;

  abstract getCategoryById(id: number): Observable<Category>;

  abstract createCategory(category: Category): Observable<Category>;

  abstract updateCategory(id: number, category: Category): Observable<void>;

  abstract deleteCategory(id: number): Observable<void>;
}
