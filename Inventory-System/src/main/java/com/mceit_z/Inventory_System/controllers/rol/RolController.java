package com.mceit_z.Inventory_System.controllers.rol;

import com.mceit_z.Inventory_System.dto.rol.RolCreateDTO;
import com.mceit_z.Inventory_System.dto.rol.RolReadDTO;
import com.mceit_z.Inventory_System.dto.rol.RolUpdateDTO;
import com.mceit_z.Inventory_System.mappers.rol.RolMapper;
import com.mceit_z.Inventory_System.models.Rol;
import com.mceit_z.Inventory_System.services.rol.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    private RolService rolService;
    private RolMapper rolMapper;

    @Autowired
    public RolController(RolService rolService, RolMapper rolMapper) {
        this.rolService = rolService;
        this.rolMapper = rolMapper;
    }

    @GetMapping("/")
    public List<RolReadDTO> getAllRolls() {
        return rolService.list().stream().map(rolMapper::toReadDTO).toList();
    }

    @GetMapping("/{id}")
    public RolReadDTO getRolById(@PathVariable Long id) {
        Rol rol = rolService.get(id).orElseThrow();
        return rolMapper.toReadDTO(rol);
    }

    @PostMapping("/add")
    public ResponseEntity<RolReadDTO> addRol(@RequestBody RolCreateDTO dto) {
        Rol rol = rolMapper.toEntity(dto);
        rolService.save(rol);
        RolReadDTO rolReadDTO = rolMapper.toReadDTO(rol);
        return ResponseEntity.status(201).body(rolReadDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolReadDTO> updateRol(@PathVariable Long id, @RequestBody RolUpdateDTO dto) {
        Rol rol = rolService.get(id).orElseThrow();
        rolMapper.updateEntityFromDTO(dto, rol);
        Rol updated = rolService.save(rol);
        return ResponseEntity.ok(rolMapper.toReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RolReadDTO> deleteRol(@PathVariable Long id) {
        Rol rol = rolService.get(id).orElseThrow();
        rolService.delete(id);
        return ResponseEntity.ok(rolMapper.toReadDTO(rol));
    }
}
