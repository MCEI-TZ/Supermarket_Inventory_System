package com.mceit_z.Inventory_System.mappers.product;

import com.mceit_z.Inventory_System.dto.product.ProductCreateDTO;
import com.mceit_z.Inventory_System.dto.product.ProductReadDTO;
import com.mceit_z.Inventory_System.dto.product.ProductUpdateDTO;
import com.mceit_z.Inventory_System.models.Product;
import com.mceit_z.Inventory_System.repo.ICategory;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private ICategory categoryRepository;

    public ProductMapper(ICategory categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Product toEntityDTO(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setDescription(productCreateDTO.getDescription());
        product.setBarcode(productCreateDTO.getBarcode());
        product.setExpirationDate(productCreateDTO.getExpirationDate());
        product.setCategory(categoryRepository.findById(productCreateDTO.getCategoryId()).orElseThrow());
        return product;
    }

    public ProductReadDTO toProductReadDTO(Product product) {
        ProductReadDTO productReadDTO = new ProductReadDTO();
        productReadDTO.setIdProduct(product.getIdProduct());
        productReadDTO.setName(product.getName());
        productReadDTO.setDescription(product.getDescription());
        productReadDTO.setBarcode(product.getBarcode());
        productReadDTO.setExpirationDate(product.getExpirationDate());
        productReadDTO.setCategoryName(product.getCategory().getName());
        return productReadDTO;
    }

    public void updateEntityFromDTO(ProductUpdateDTO dto, Product product) {
        if (dto.getName() != null) {
            product.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            product.setDescription(dto.getDescription());
        }
        if (dto.getBarcode() != null) {
            product.setBarcode(dto.getBarcode());
        }
        if (dto.getExpirationDate() != null) {
            product.setExpirationDate(dto.getExpirationDate());
        }
        if (dto.getCategoryId() != null) {
            product.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow());
        }
    }

}
