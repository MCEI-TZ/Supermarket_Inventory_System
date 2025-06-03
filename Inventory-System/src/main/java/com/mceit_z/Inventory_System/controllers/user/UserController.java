package com.mceit_z.Inventory_System.controllers.user;

import com.mceit_z.Inventory_System.dto.user.UserCreateDTO;
import com.mceit_z.Inventory_System.dto.user.UserReadDTO;
import com.mceit_z.Inventory_System.dto.user.UserUpdateDTO;
import com.mceit_z.Inventory_System.mappers.user.UserMapper;
import com.mceit_z.Inventory_System.models.UserProfile;
import com.mceit_z.Inventory_System.services.user.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserProfileService userProfileService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserProfileService userProfileService, UserMapper userMapper) {
        this.userProfileService = userProfileService;
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public List<UserReadDTO> getAllUsers() {
        return userProfileService.list().stream().map(userMapper::toUserReadDTO).toList();
    }

    @GetMapping("/{id}")
    public UserReadDTO getUserById(@PathVariable Long id) {
        UserProfile userProfile = userProfileService.get(id).orElseThrow();
        return userMapper.toUserReadDTO(userProfile);
    }

    @PostMapping("/add")
    public ResponseEntity<UserReadDTO> addUser(@RequestBody UserCreateDTO dto) {
        UserProfile user = userMapper.toUserProfile(dto);
        userProfileService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toUserReadDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReadDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO dto) {
        UserProfile existUser = userProfileService.get(id).orElseThrow();
        userMapper.updateUserProfileFromDTO(dto, existUser);
        UserProfile updated = userProfileService.save(existUser);
        return ResponseEntity.ok(userMapper.toUserReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserReadDTO> deleteUser(@PathVariable Long id) {
        UserProfile deleteUser = userProfileService.get(id).orElseThrow();
        userProfileService.delete(id);
        return ResponseEntity.ok(userMapper.toUserReadDTO(deleteUser));
    }
}
