package com.mceit_z.Inventory_System.mappers.inventoryMovements;

import com.mceit_z.Inventory_System.dto.inventoryMovements.InventoryMovementCreateDTO;
import com.mceit_z.Inventory_System.dto.inventoryMovements.InventoryMovementReadDTO;
import com.mceit_z.Inventory_System.dto.inventoryMovements.InventoryMovementUpdateDTO;
import com.mceit_z.Inventory_System.models.InventoryMovements;
import com.mceit_z.Inventory_System.repo.IProductStock;
import com.mceit_z.Inventory_System.repo.IUser;
import org.springframework.stereotype.Component;

@Component
public class InventoryMovementsMapper {

    private IProductStock productStockRepository;
    private IUser userRepository;

    public InventoryMovementsMapper(IProductStock productStockRepository, IUser userRepository) {
        this.productStockRepository = productStockRepository;
        this.userRepository = userRepository;
    }

    public InventoryMovements toEntity(InventoryMovementCreateDTO dto) {
        InventoryMovements inventoryMovements = new InventoryMovements();
        inventoryMovements.setProductStock(productStockRepository.findById(dto.getProductStockId()).orElseThrow());
        inventoryMovements.setUser(userRepository.findById(dto.getUserId()).orElseThrow());
        inventoryMovements.setMovementType(dto.getMovementType());
        inventoryMovements.setQuantity(dto.getQuantity());
        inventoryMovements.setDate(dto.getDate());
        inventoryMovements.setReason(dto.getReason());
        return inventoryMovements;
    }

    public InventoryMovementReadDTO toReadDTO(InventoryMovements inventoryMovements) {
        InventoryMovementReadDTO dto = new InventoryMovementReadDTO();
        dto.setIdInventoryMovement(inventoryMovements.getIdInventoryMovement());
        dto.setProductName(inventoryMovements.getProductStock().getProduct().getName());
        dto.setBranchName(inventoryMovements.getProductStock().getBranch().getName());
        dto.setSupplierName(inventoryMovements.getProductStock().getSupplier().getName());
        dto.setUserName(inventoryMovements.getUser().getUsername());
        dto.setMovementType(inventoryMovements.getMovementType());
        dto.setQuantity(inventoryMovements.getQuantity());
        dto.setDate(inventoryMovements.getDate());
        dto.setReason(inventoryMovements.getReason());
        return dto;
    }

    public void updateEntityFromDTO(InventoryMovementUpdateDTO inventoryMovementUpdateDTO, InventoryMovements inventoryMovements) {
        if (inventoryMovementUpdateDTO.getProductStockId() != null) {
            inventoryMovements.setProductStock(productStockRepository.findById(inventoryMovementUpdateDTO.getProductStockId()).orElseThrow());
        }
        if (inventoryMovementUpdateDTO.getUserId() != null) {
            inventoryMovements.setUser(userRepository.findById(inventoryMovementUpdateDTO.getUserId()).orElseThrow());
        }
        if (inventoryMovementUpdateDTO.getMovementType() != null) {
            inventoryMovements.setMovementType(inventoryMovementUpdateDTO.getMovementType());
        }
        if (inventoryMovementUpdateDTO.getQuantity() != null) {
            inventoryMovements.setQuantity(inventoryMovementUpdateDTO.getQuantity());
        }
        if (inventoryMovementUpdateDTO.getDate() != null) {
            inventoryMovements.setDate(inventoryMovementUpdateDTO.getDate());
        }
        if (inventoryMovementUpdateDTO.getReason() != null) {
            inventoryMovements.setReason(inventoryMovementUpdateDTO.getReason());
        }
    }
}
