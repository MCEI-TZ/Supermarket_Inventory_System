package com.mceit_z.Inventory_System.services.product.impl;

import com.mceit_z.Inventory_System.models.Product;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.repo.IProduct;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;
import com.mceit_z.Inventory_System.services.product.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceIImpl<Product,Long, IProduct> implements ProductService {
}
