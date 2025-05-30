package com.mceit_z.Inventory_System.services.productStock.Impl;

import com.mceit_z.Inventory_System.models.ProductStock;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.repo.IProductStock;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;
import com.mceit_z.Inventory_System.services.productStock.ProductStockService;

@Service
public class ProductStockServiceImpl extends GenericServiceIImpl<ProductStock,Long, IProductStock> implements ProductStockService {
}
