package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.Category;

import java.util.List;

/**
 * Service interface for managing product categories.
 * Defines CRUD operations for the Category entity.
 */
public interface CategoryService {

    Category create(Category category);

    Category getById(Long id);

    List<Category> getAll();

    Category update(Long id, Category category);

    void delete(Long id);
}
