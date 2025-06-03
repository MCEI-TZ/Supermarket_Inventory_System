package com.mceit_z.Inventory_System.dto.inventoryMovements;

import com.mceit_z.Inventory_System.models.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryMovementReadDTO {
    private Long idInventoryMovement;
    private String productName;
    private String branchName;
    private String supplierName;
    private String userName;

    private MovementType movementType; // e.g., "IN", "OUT", "ADJUSTMENT"
    private Long quantity;
    private Date date; // Consider using LocalDate or LocalDateTime for better date handling
    private String reason; // Optional description of the movement
}
