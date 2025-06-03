package com.mceit_z.Inventory_System.controllers.branch;

import com.mceit_z.Inventory_System.dto.branch.BranchCreateDTO;
import com.mceit_z.Inventory_System.dto.branch.BranchReadDTO;
import com.mceit_z.Inventory_System.dto.branch.BranchUpdateDTO;
import com.mceit_z.Inventory_System.mappers.branch.BranchMapper;
import com.mceit_z.Inventory_System.models.Branch;
import com.mceit_z.Inventory_System.services.branch.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/branch")
public class BranchController {

    private BranchService branchService;
    private BranchMapper branchMapper;

    @Autowired
    public BranchController(BranchService branchService, BranchMapper branchMapper) {
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }

    @GetMapping("/")
    public List<BranchReadDTO> getBranch() {
        return branchService.list().stream().map(branchMapper::toReadDTO).toList();
    }

    @GetMapping("/{id}")
    public BranchReadDTO getBranchById(@PathVariable Long id) {
        Branch branch = branchService.get(id).orElseThrow();
        return branchMapper.toReadDTO(branch);
    }

    @PostMapping("/add")
    public ResponseEntity<BranchReadDTO> addBranch(@RequestBody BranchCreateDTO dto) {
        Branch branch = branchMapper.toEntity(dto);
        branchService.save(branch);
        return ResponseEntity.status(HttpStatus.CREATED).body(branchMapper.toReadDTO(branch));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchReadDTO> updateBranch(@PathVariable Long id, @RequestBody BranchUpdateDTO branch) {
        Branch existingBranch = branchService.get(id).orElseThrow();
        branchMapper.updateEntityFromDto(branch, existingBranch);
        Branch updated = branchService.save(existingBranch);
        return ResponseEntity.status(HttpStatus.OK).body(branchMapper.toReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BranchReadDTO> deleteBranch(@PathVariable Long id) {
        Branch deleteBranch = branchService.get(id).orElseThrow();
        branchService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(branchMapper.toReadDTO(deleteBranch));
    }
}
