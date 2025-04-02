package ch.csbe.productmanagment.repository;

import ch.csbe.productmanagment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Retrieves all products that belong to the specified category.
     *
     * @param categoryId the ID of the category
     * @return list of products assigned to the given category
     */
    List<Product> findByCategoryId(Long categoryId);
}
