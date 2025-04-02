package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.Category;
import ch.csbe.productmanagment.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for category-related operations.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        // Retrieves a category by ID or throws an exception if not found
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category with ID " + id + " not found"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Long id, Category category) {
        // Updates only the name of the category
        Category existing = getById(id);
        existing.setName(category.getName());
        return categoryRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
