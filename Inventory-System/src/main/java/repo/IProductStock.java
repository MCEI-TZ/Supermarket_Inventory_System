package repo;

import models.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductStock extends JpaRepository<ProductStock,Long> {
}
