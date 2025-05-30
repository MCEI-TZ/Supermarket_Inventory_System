package services.product.impl;

import models.Product;
import org.springframework.stereotype.Service;
import repo.IProduct;
import services.generic.Impl.GenericServiceIImpl;
import services.product.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceIImpl<Product,Long, IProduct> implements ProductService {
}
