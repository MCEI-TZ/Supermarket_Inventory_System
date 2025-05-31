package com.mceit_z.Inventory_System.services.supplier.Impl;

import com.mceit_z.Inventory_System.models.Supplier;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.repo.ISupplier;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;
import com.mceit_z.Inventory_System.services.supplier.SupplierService;

@Service
public class SupplierServiceImpl extends GenericServiceIImpl<Supplier,Long, ISupplier> implements SupplierService {
}
