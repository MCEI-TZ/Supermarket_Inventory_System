package com.mceit_z.Inventory_System.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierUpdateDTO {
    private Long idSupplier;

    private String name;

    private String ContactName;

    private String email;

    private String phone;

    private String address;
}
