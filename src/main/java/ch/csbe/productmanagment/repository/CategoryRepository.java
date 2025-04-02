package ch.csbe.productmanagment.repository;

import ch.csbe.productmanagment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Category entities.
 * Inherits basic CRUD operations from JpaRepository.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
