package com.mceit_z.Inventory_System.controllers.inventoryMovements;

import com.mceit_z.Inventory_System.dto.inventoryMovements.InventoryMovementCreateDTO;
import com.mceit_z.Inventory_System.dto.inventoryMovements.InventoryMovementReadDTO;
import com.mceit_z.Inventory_System.dto.inventoryMovements.InventoryMovementUpdateDTO;
import com.mceit_z.Inventory_System.mappers.inventoryMovements.InventoryMovementsMapper;
import com.mceit_z.Inventory_System.models.InventoryMovements;
import com.mceit_z.Inventory_System.services.InventoryMovement.InventoryMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventory-movements")
public class InventoryMovementsController {

    private InventoryMovementService inventoryMovementService;
    private InventoryMovementsMapper inventoryMovementsMapper;

    @Autowired
    public InventoryMovementsController(InventoryMovementService inventoryMovementService, InventoryMovementsMapper inventoryMovementsMapper) {
        this.inventoryMovementService = inventoryMovementService;
        this.inventoryMovementsMapper = inventoryMovementsMapper;
    }

    @GetMapping("/")
    public List<InventoryMovementReadDTO> getInventoryMovements() {
        List<InventoryMovements> inventoryMovements = inventoryMovementService.list();
        return inventoryMovements.stream().toList().stream().map(inventoryMovementsMapper::toReadDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public InventoryMovementReadDTO getInventoryMovementById(@PathVariable Long id) {
        InventoryMovements inventoryMovement = inventoryMovementService.get(id).orElseThrow();
        return inventoryMovementsMapper.toReadDTO(inventoryMovement);
    }

    @PostMapping("/add")
    public ResponseEntity<InventoryMovementReadDTO> addInventoryMovement(@RequestBody InventoryMovementCreateDTO inventoryMovements) {
        InventoryMovements inventoryMovement = inventoryMovementsMapper.toEntity(inventoryMovements);
        inventoryMovementService.save(inventoryMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryMovementsMapper.toReadDTO(inventoryMovement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryMovementReadDTO> updateInventoryMovement(@PathVariable Long id, @RequestBody InventoryMovementUpdateDTO inventoryMovements) {
        InventoryMovements existingInventoryMovement = inventoryMovementService.get(id).orElseThrow();
        inventoryMovementsMapper.updateEntityFromDTO(inventoryMovements, existingInventoryMovement);
        InventoryMovements updated = inventoryMovementService.save(existingInventoryMovement);
        return ResponseEntity.ok(inventoryMovementsMapper.toReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryMovementReadDTO> deleteInventoryMovement(@PathVariable Long id) {
        InventoryMovements existingInventoryMovement = inventoryMovementService.get(id).orElseThrow();
        inventoryMovementService.delete(id);
        return ResponseEntity.ok(inventoryMovementsMapper.toReadDTO(existingInventoryMovement));
    }
}
