package com.mceit_z.Inventory_System.controllers.product;

import com.mceit_z.Inventory_System.dto.product.ProductCreateDTO;
import com.mceit_z.Inventory_System.dto.product.ProductReadDTO;
import com.mceit_z.Inventory_System.dto.product.ProductUpdateDTO;
import com.mceit_z.Inventory_System.mappers.product.ProductMapper;
import com.mceit_z.Inventory_System.models.Product;
import com.mceit_z.Inventory_System.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/")
    public List<ProductReadDTO> getAllProducts() {
        List<Product> products = productService.list();
        return products.stream().map(productMapper::toProductReadDTO).toList();
    }

    @GetMapping("/{id}")
    public ProductReadDTO getProductById(@PathVariable Long id) {
        Product product = productService.get(id).orElseThrow();
        return productMapper.toProductReadDTO(product);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductReadDTO> addProduct(@RequestBody ProductCreateDTO dto) {
        Product product = productMapper.toEntityDTO(dto);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toProductReadDTO(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductReadDTO> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO dto) {
        Product product = productService.get(id).orElseThrow();
        productMapper.updateEntityFromDTO(dto, product);
        Product updated = productService.save(product);
        return ResponseEntity.ok(productMapper.toProductReadDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductReadDTO> deleteProduct(@PathVariable Long id) {
        Product product = productService.get(id).orElseThrow();
        productService.delete(id);
        return ResponseEntity.ok(productMapper.toProductReadDTO(product));
    }
}
