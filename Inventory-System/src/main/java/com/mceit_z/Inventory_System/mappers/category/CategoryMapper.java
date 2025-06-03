package com.mceit_z.Inventory_System.mappers.category;

import com.mceit_z.Inventory_System.dto.category.CategoryCreateDTO;
import com.mceit_z.Inventory_System.dto.category.CategoryReadDTO;
import com.mceit_z.Inventory_System.dto.category.CategoryUpdateDTO;
import com.mceit_z.Inventory_System.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryCreateDTO categoryCreateDTO) {
        Category category = new Category();
        category.setName(categoryCreateDTO.getName());
        category.setDescription(categoryCreateDTO.getDescription());
        return category;
    }

    public CategoryReadDTO toReadDTO(Category category) {
        CategoryReadDTO categoryReadDTO = new CategoryReadDTO();
        categoryReadDTO.setIdCategory(category.getIdCategory());
        categoryReadDTO.setName(category.getName());
        categoryReadDTO.setDescription(category.getDescription());
        return categoryReadDTO;
    }

    public void updateEntityFromDTO(CategoryUpdateDTO categoryUpdateDTO, Category category) {
        if (categoryUpdateDTO.getName() != null) {
            category.setName(categoryUpdateDTO.getName());
        }
        if (categoryUpdateDTO.getDescription() != null) {
            category.setDescription(categoryUpdateDTO.getDescription());
        }
    }
}
