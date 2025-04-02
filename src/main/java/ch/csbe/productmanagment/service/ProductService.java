package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.Product;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * Creates a new product.
     */
    Product create(Product product);

    /**
     * Retrieves a product by its ID.
     */
    Product getById(Long id);

    /**
     * Retrieves all products.
     */
    List<Product> getAll();

    /**
     * Updates an existing product.
     */
    Product update(Long id, Product product);

    /**
     * Deletes a product by its ID.
     */
    void delete(Long id);

    /**
     * Retrieves all products associated with a specific category ID.
     */
    List<Product> getByCategoryId(Long categoryId);
}
