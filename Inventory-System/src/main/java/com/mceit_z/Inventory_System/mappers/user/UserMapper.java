package com.mceit_z.Inventory_System.mappers.user;

import com.mceit_z.Inventory_System.config.jwt.CryptPasswordEncoder;
import com.mceit_z.Inventory_System.dto.user.UserCreateDTO;
import com.mceit_z.Inventory_System.dto.user.UserReadDTO;
import com.mceit_z.Inventory_System.dto.user.UserUpdateDTO;
import com.mceit_z.Inventory_System.models.UserProfile;
import com.mceit_z.Inventory_System.repo.IBranch;
import com.mceit_z.Inventory_System.repo.IRol;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private IBranch branchRespository;
    private IRol rolRepository;
    private CryptPasswordEncoder passwordEncoder;

    public UserMapper(IBranch branchRespository, IRol rolRepository, CryptPasswordEncoder passwordEncoder) {
        this.branchRespository = branchRespository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserProfile toUserProfile(UserCreateDTO userCreateDTO) {
        UserProfile newUser = new UserProfile();
        newUser.setUsername(userCreateDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        newUser.setEmail(userCreateDTO.getEmail());
        newUser.setFullName(userCreateDTO.getFullName());
        newUser.setRol(rolRepository.findById(userCreateDTO.getRolId()).orElseThrow());
        newUser.setBranch(branchRespository.findById(userCreateDTO.getBranchId()).orElseThrow());
        return newUser;
    }

    public UserReadDTO toUserReadDTO(UserProfile userProfile) {
        UserReadDTO dto = new UserReadDTO();
        dto.setIdUser(userProfile.getIdUser());
        dto.setUsername(userProfile.getUsername());
        dto.setPassword(userProfile.getPassword());
        dto.setEmail(userProfile.getEmail());
        dto.setFullName(userProfile.getFullName());
        dto.setRolName(userProfile.getRol().getName());
        dto.setBranchName(userProfile.getBranch().getName());
        return dto;
    }

    public void updateUserProfileFromDTO(UserUpdateDTO updateDTO, UserProfile user) {
        if (updateDTO.getIdUser() != null) {
            user.setIdUser(updateDTO.getIdUser());
        }
        if (updateDTO.getUsername() != null) {
            user.setUsername(updateDTO.getUsername());
        }
        if (updateDTO.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(updateDTO.getPassword()));
        }
        if (updateDTO.getEmail() != null) {
            user.setEmail(updateDTO.getEmail());
        }
        if (updateDTO.getFullName() != null) {
            user.setFullName(updateDTO.getFullName());
        }
        if (updateDTO.getRolId() != null) {
            user.setRol(rolRepository.findById(updateDTO.getRolId()).orElseThrow());
        }
        if (updateDTO.getBranchId() != null) {
            user.setBranch(branchRespository.findById(updateDTO.getBranchId()).orElseThrow());
        }
    }

}
