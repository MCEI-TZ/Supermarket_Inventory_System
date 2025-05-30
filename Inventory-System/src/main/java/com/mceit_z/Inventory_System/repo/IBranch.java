package com.mceit_z.Inventory_System.repo;

import com.mceit_z.Inventory_System.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranch extends JpaRepository<Branch,Long> {
}
