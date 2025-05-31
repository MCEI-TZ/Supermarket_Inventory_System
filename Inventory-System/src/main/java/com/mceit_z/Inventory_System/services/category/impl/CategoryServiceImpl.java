package com.mceit_z.Inventory_System.services.category.impl;

import com.mceit_z.Inventory_System.models.Category;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.repo.ICategory;
import com.mceit_z.Inventory_System.services.category.CategoryService;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;

@Service
public class CategoryServiceImpl extends GenericServiceIImpl<Category,Long, ICategory> implements CategoryService {
}
