package com.mceit_z.Inventory_System.controllers.productStock;

import com.mceit_z.Inventory_System.dto.ProductStock.ProductStockCreateDTO;
import com.mceit_z.Inventory_System.dto.ProductStock.ProductStockReadDTO;
import com.mceit_z.Inventory_System.dto.ProductStock.ProductStockUpdateDTO;
import com.mceit_z.Inventory_System.mappers.productStock.ProductStockMapper;
import com.mceit_z.Inventory_System.models.ProductStock;
import com.mceit_z.Inventory_System.services.productStock.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-stocks")
public class ProductStockController {

    private ProductStockService productStockService;
    private ProductStockMapper productStockMapper;

    @Autowired
    public ProductStockController(ProductStockService productStockService, ProductStockMapper productStockMapper) {
        this.productStockService = productStockService;
        this.productStockMapper = productStockMapper;
    }

    @GetMapping("/")
    public List<ProductStockReadDTO> getAllProductStocks() {
        return productStockService.list().stream().map(productStockMapper::toReadDTO).toList();
    }

    @GetMapping("/{id}")
    public ProductStockReadDTO getProductStockById(@PathVariable Long id) {
        return productStockService.get(id)
                .map(productStockMapper::toReadDTO)
                .orElseThrow();
    }

    @PostMapping("/add")
    public ResponseEntity<ProductStockReadDTO> addProductStock(@RequestBody ProductStockCreateDTO dto) {
        var productStock = productStockMapper.toEntity(dto);
        ProductStock saved = productStockService.save(productStock);
        return ResponseEntity.status(HttpStatus.CREATED).body(productStockMapper.toReadDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductStockReadDTO> updateProductStock(@PathVariable Long id, @RequestBody ProductStockUpdateDTO dto) {
        ProductStock productStock = productStockService.get(id).orElseThrow();
        productStockMapper.updateEntityFromDTO(dto, productStock);
        ProductStock updated = productStockService.save(productStock);
        return ResponseEntity.ok(productStockMapper.toReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductStockReadDTO> deleteProductStock(@PathVariable Long id) {
        var productStock = productStockService.get(id).orElseThrow();
        productStockService.delete(id);
        return ResponseEntity.ok(productStockMapper.toReadDTO(productStock));
    }

}
