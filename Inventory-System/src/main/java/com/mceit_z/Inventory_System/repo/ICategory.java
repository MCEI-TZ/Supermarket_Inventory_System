package com.mceit_z.Inventory_System.repo;

import com.mceit_z.Inventory_System.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategory extends JpaRepository<Category,Long> {
}
