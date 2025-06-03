package com.mceit_z.Inventory_System.models.enums;

public enum MovementType {
    IN, // Represents incoming stock, such as purchases or returns
    OUT, // Represents outgoing stock, such as sales or consumption
    ADJUSTMENT, // Represents manual adjustments to stock levels
    TRANSFER, // Represents stock transfers between locations
    RETURN, // Represents returns from customers or to suppliers
    DAMAGED, // Represents stock that is damaged and needs to be removed
    LOST, // Represents stock that is lost or unaccounted for an unknown reason
    UNKNOWN,
    INITIAL, // Represents the initial stock load when setting up the inventory system
}
