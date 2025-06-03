package com.mceit_z.Inventory_System.mappers.supplier;

import com.mceit_z.Inventory_System.dto.supplier.SupplierCreateDTO;
import com.mceit_z.Inventory_System.dto.supplier.SupplierReadDTO;
import com.mceit_z.Inventory_System.dto.supplier.SupplierUpdateDTO;
import com.mceit_z.Inventory_System.models.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public Supplier toSupplier(SupplierCreateDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.getName());
        supplier.setContactName(dto.getContactName());
        supplier.setEmail(dto.getEmail());
        supplier.setPhone(dto.getPhone());
        supplier.setAddress(dto.getAddress());
        return supplier;
    }

    public SupplierReadDTO toSupplierReadDTO(Supplier supplier) {
        SupplierReadDTO dto = new SupplierReadDTO();
        dto.setIdSupplier(supplier.getIdSupplier());
        dto.setName(supplier.getName());
        dto.setContactName(supplier.getContactName());
        dto.setEmail(supplier.getEmail());
        dto.setPhone(supplier.getPhone());
        dto.setAddress(supplier.getAddress());
        return dto;
    }

    public void updateSupplierFromDTO(SupplierUpdateDTO dto, Supplier supplier) {
        if (dto.getName() != null) {
            supplier.setName(dto.getName());
        }
        if (dto.getContactName() != null) {
            supplier.setContactName(dto.getContactName());
        }
        if (dto.getEmail() != null) {
            supplier.setEmail(dto.getEmail());
        }
        if (dto.getPhone() != null) {
            supplier.setPhone(dto.getPhone());
        }
        if (dto.getAddress() != null) {
            supplier.setAddress(dto.getAddress());
        }
    }
}
