package com.mceit_z.Inventory_System.dto.inventoryMovements;

import com.mceit_z.Inventory_System.models.ProductStock;
import com.mceit_z.Inventory_System.models.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryMovementReadDTO {
    private ProductStock productStock;
    private UserProfile user;
    private String movementType; // e.g., "IN", "OUT", "ADJUSTMENT"
    private Long quantity;
    private String date; // Consider using LocalDate or LocalDateTime for better date handling
    private String reason; // Optional description of the movement
}
