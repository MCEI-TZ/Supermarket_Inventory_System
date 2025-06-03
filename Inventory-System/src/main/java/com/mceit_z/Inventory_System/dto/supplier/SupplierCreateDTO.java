package com.mceit_z.Inventory_System.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierCreateDTO {

    private String name;

    private String contactName;

    private String email;

    private String phone;

    private String address;
}
