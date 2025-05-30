package services.supplier.Impl;

import models.Supplier;
import org.springframework.stereotype.Service;
import repo.ISupplier;
import services.generic.Impl.GenericServiceIImpl;
import services.supplier.SupplierService;

@Service
public class SupplierServiceImpl extends GenericServiceIImpl<Supplier,Long, ISupplier> implements SupplierService {
}
