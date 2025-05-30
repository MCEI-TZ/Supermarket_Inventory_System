package repo;

import models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranch extends JpaRepository<Branch,Long> {
}
