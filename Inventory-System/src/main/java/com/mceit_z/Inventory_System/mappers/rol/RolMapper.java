package com.mceit_z.Inventory_System.mappers.rol;

import com.mceit_z.Inventory_System.dto.rol.RolCreateDTO;
import com.mceit_z.Inventory_System.dto.rol.RolReadDTO;
import com.mceit_z.Inventory_System.dto.rol.RolUpdateDTO;
import com.mceit_z.Inventory_System.models.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public Rol toEntity(RolCreateDTO rolCreateDTO) {
        Rol rol = new Rol();
        rol.setName(rolCreateDTO.getName());
        return rol;
    }

    public RolReadDTO toReadDTO(Rol rol) {
        RolReadDTO dto = new RolReadDTO();
        dto.setIdRol(rol.getIdRol());
        dto.setName(rol.getName());
        return dto;
    }


    public void updateEntityFromDTO(RolUpdateDTO dto, Rol rol) {
        if (dto.getName() != null) {
            rol.setName(dto.getName());
        }
    }
}
