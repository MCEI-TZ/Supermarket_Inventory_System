package repo;

import models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategory extends JpaRepository<Category,Long> {
}
