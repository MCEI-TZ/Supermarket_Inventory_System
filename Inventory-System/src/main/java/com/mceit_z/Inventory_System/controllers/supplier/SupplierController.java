package com.mceit_z.Inventory_System.controllers.supplier;

import com.mceit_z.Inventory_System.dto.supplier.SupplierCreateDTO;
import com.mceit_z.Inventory_System.dto.supplier.SupplierReadDTO;
import com.mceit_z.Inventory_System.dto.supplier.SupplierUpdateDTO;
import com.mceit_z.Inventory_System.mappers.supplier.SupplierMapper;
import com.mceit_z.Inventory_System.models.Supplier;
import com.mceit_z.Inventory_System.services.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    private SupplierService supplierService;
    private SupplierMapper supplierMapper;

    @Autowired
    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
    }

    @GetMapping("/")
    public List<SupplierReadDTO> getAllSuppliers() {
        return supplierService.list().stream().map(supplierMapper::toSupplierReadDTO).toList();
    }

    @GetMapping("/{id}")
    public SupplierReadDTO getSupplierReadDTO(@PathVariable Long id) {
        Supplier supplier = supplierService.get(id).orElseThrow();
        return supplierMapper.toSupplierReadDTO(supplier);
    }

    @PostMapping("/add")
    public ResponseEntity<SupplierReadDTO> addSupplier(@RequestBody SupplierCreateDTO dto) {
        Supplier supplier = supplierMapper.toSupplier(dto);
        supplierService.save(supplier);
        return ResponseEntity.status(201).body(supplierMapper.toSupplierReadDTO(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierReadDTO> udpateSupplier(@PathVariable Long id, @RequestBody SupplierUpdateDTO dto) {
        Supplier existsupplier = supplierService.get(id).orElseThrow();
        supplierMapper.updateSupplierFromDTO(dto, existsupplier);
        Supplier updated = supplierService.save(existsupplier);
        return ResponseEntity.ok(supplierMapper.toSupplierReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierReadDTO> deleteSupplier(@PathVariable Long id) {
        Supplier supplier = supplierService.get(id).orElseThrow();
        supplierService.delete(id);
        return ResponseEntity.ok(supplierMapper.toSupplierReadDTO(supplier));
    }
}
