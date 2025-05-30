package repo;

import models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplier extends JpaRepository<Supplier,Long> {
}
