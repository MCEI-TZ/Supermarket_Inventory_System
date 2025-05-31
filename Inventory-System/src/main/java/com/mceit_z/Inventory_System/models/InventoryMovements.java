package com.mceit_z.Inventory_System.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class InventoryMovements implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_inventory_movement")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventoryMovement;

    @ManyToOne
    @JoinColumn(name = "id_product_stock")
    private ProductStock productStock;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserProfile user; // Assuming you have a UserProfile entity representing the user who made the movement

    private String movementType; // e.g., "IN", "OUT", "ADJUSTMENT"

    private Long quantity;
    private String date; // Consider using LocalDate or LocalDateTime for better date handling

    private String reason; // Optional description of the movement
}
