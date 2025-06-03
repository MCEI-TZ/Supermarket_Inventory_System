package com.mceit_z.Inventory_System.mappers.productStock;

import com.mceit_z.Inventory_System.dto.ProductStock.ProductStockCreateDTO;
import com.mceit_z.Inventory_System.dto.ProductStock.ProductStockReadDTO;
import com.mceit_z.Inventory_System.dto.ProductStock.ProductStockUpdateDTO;
import com.mceit_z.Inventory_System.models.ProductStock;
import com.mceit_z.Inventory_System.repo.IBranch;
import com.mceit_z.Inventory_System.repo.IProduct;
import com.mceit_z.Inventory_System.repo.ISupplier;
import org.springframework.stereotype.Component;

@Component
public class ProductStockMapper {

    private IProduct productRepository;
    private IBranch branchRepository;
    private ISupplier supplierRepository;

    public ProductStockMapper(IProduct productRepository, IBranch branchRepository, ISupplier supplierRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.supplierRepository = supplierRepository;
    }


    public ProductStock toEntity(ProductStockCreateDTO dto) {
        ProductStock stock = new ProductStock();
        stock.setProduct(productRepository.findById(dto.getProductId()).orElseThrow());
        stock.setBranch(branchRepository.findById(dto.getBranchId()).orElseThrow());
        stock.setSupplier(supplierRepository.findById(dto.getSupplierId()).orElseThrow());
        stock.setQuantity(dto.getQuantity());
        stock.setPrice(dto.getPrice());
        stock.setLastRestockDate(dto.getLastRestockDate());
        return stock;
    }

    public ProductStockReadDTO toReadDTO(ProductStock productStock) {
        ProductStockReadDTO dto = new ProductStockReadDTO();
        dto.setIdProductStock(productStock.getIdProductStock());
        dto.setProductName(productStock.getProduct().getName());
        dto.setBranchName(productStock.getBranch().getName());
        dto.setSupplierName(productStock.getSupplier().getName());
        dto.setQuantity(productStock.getQuantity());
        dto.setPrice(productStock.getPrice());
        dto.setLastRestockDate(productStock.getLastRestockDate());
        return dto;
    }

    public void updateEntityFromDTO(ProductStockUpdateDTO updateDTO, ProductStock stock) {
        if (updateDTO.getProductId() != null) {
            stock.setProduct(productRepository.findById(updateDTO.getProductId()).orElseThrow());
        }
        if (updateDTO.getBranchId() != null) {
            stock.setBranch(branchRepository.findById(updateDTO.getBranchId()).orElseThrow());
        }
        if (updateDTO.getSupplierId() != null) {
            stock.setSupplier(supplierRepository.findById(updateDTO.getSupplierId()).orElseThrow());
        }
        if (updateDTO.getQuantity() != 0) {
            stock.setQuantity(updateDTO.getQuantity());
        }
        if (updateDTO.getPrice() != 0) {
            stock.setPrice(updateDTO.getPrice());
        }
        if (updateDTO.getLastRestockDate() != null) {
            stock.setLastRestockDate(updateDTO.getLastRestockDate());
        }
    }

}
