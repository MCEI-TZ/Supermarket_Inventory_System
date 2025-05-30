package services.category.impl;

import models.Category;
import org.springframework.stereotype.Service;
import repo.ICategory;
import services.category.CategoryService;
import services.generic.Impl.GenericServiceIImpl;

@Service
public class CategoryServiceImpl extends GenericServiceIImpl<Category,Long, ICategory> implements CategoryService {
}
