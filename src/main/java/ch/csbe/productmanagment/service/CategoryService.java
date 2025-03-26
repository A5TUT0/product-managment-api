package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);
    Category getById(Long id);
    List<Category> getAll();
    Category update(Long id, Category category);
    void delete(Long id);
}
