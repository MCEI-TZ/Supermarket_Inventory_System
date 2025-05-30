package repo;

import models.InventoryMovements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryMovement extends JpaRepository<InventoryMovements,Long> {
}
