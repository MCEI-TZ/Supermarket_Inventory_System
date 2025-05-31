package com.mceit_z.Inventory_System.repo;


import com.mceit_z.Inventory_System.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<UserProfile,Long> {
    UserProfile findByUsername(String username);
}
