package com.mceit_z.Inventory_System.controllers.category;

import com.mceit_z.Inventory_System.dto.category.CategoryCreateDTO;
import com.mceit_z.Inventory_System.dto.category.CategoryReadDTO;
import com.mceit_z.Inventory_System.dto.category.CategoryUpdateDTO;
import com.mceit_z.Inventory_System.mappers.category.CategoryMapper;
import com.mceit_z.Inventory_System.models.Category;
import com.mceit_z.Inventory_System.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/")
    public List<CategoryReadDTO> getCategories() {
        List<Category> categories = categoryService.list();

        return categories.stream()
                .map(categoryMapper::toReadDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryReadDTO getCategoryById(@PathVariable Long id) {
        Category category = categoryService.get(id).orElseThrow();
        return categoryMapper.toReadDTO(category);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryReadDTO> addCategory(@RequestBody CategoryCreateDTO category) {
        Category createdCategory = categoryMapper.toEntity(category);
        categoryService.save(createdCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.toReadDTO(createdCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryReadDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateDTO category) {
        Category existingCategory = categoryService.get(id).orElseThrow();
        categoryMapper.updateEntityFromDTO(category, existingCategory);
        Category updated = categoryService.save(existingCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.toReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryReadDTO> deleteCategory(@PathVariable Long id) {
        Category existingCategory = categoryService.get(id).orElseThrow();
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryMapper.toReadDTO(existingCategory));
    }
}
