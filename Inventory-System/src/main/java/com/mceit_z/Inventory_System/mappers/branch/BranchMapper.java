package com.mceit_z.Inventory_System.mappers.branch;

import com.mceit_z.Inventory_System.dto.branch.BranchCreateDTO;
import com.mceit_z.Inventory_System.dto.branch.BranchReadDTO;
import com.mceit_z.Inventory_System.dto.branch.BranchUpdateDTO;
import com.mceit_z.Inventory_System.models.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    public Branch toEntity(BranchCreateDTO branchCreateDTO) {
        Branch branch = new Branch();
        branch.setName(branchCreateDTO.getName());
        branch.setAddress(branchCreateDTO.getAddress());
        branch.setCity(branchCreateDTO.getCity());
        branch.setRegion(branchCreateDTO.getRegion());
        return branch;
    }

    public BranchReadDTO toReadDTO(Branch branch) {
        BranchReadDTO dto = new BranchReadDTO();
        dto.setIdBranch(branch.getIdBranch());
        dto.setName(branch.getName());
        dto.setAddress(branch.getAddress());
        dto.setCity(branch.getCity());
        dto.setRegion(branch.getRegion());
        return dto;
    }

    public void updateEntityFromDto(BranchUpdateDTO branchUpdateDTO, Branch branch) {
        if (branchUpdateDTO.getName() != null) {
            branch.setName(branchUpdateDTO.getName());
        }
        if (branchUpdateDTO.getAddress() != null) {
            branch.setAddress(branchUpdateDTO.getAddress());
        }
        if (branchUpdateDTO.getCity() != null) {
            branch.setCity(branchUpdateDTO.getCity());
        }
        if (branchUpdateDTO.getRegion() != null) {
            branch.setRegion(branchUpdateDTO.getRegion());
        }
    }
}
