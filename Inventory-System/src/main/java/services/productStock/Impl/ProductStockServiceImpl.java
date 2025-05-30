package services.productStock.Impl;

import models.ProductStock;
import org.springframework.stereotype.Service;
import repo.IProductStock;
import services.generic.Impl.GenericServiceIImpl;
import services.productStock.ProductStockService;

@Service
public class ProductStockServiceImpl extends GenericServiceIImpl<ProductStock,Long, IProductStock> implements ProductStockService {
}
