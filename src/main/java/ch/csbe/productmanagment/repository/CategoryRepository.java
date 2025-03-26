package ch.csbe.productmanagment.repository;

import ch.csbe.productmanagment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
