package ch.csbe.productmanagment.controller;

import ch.csbe.productmanagment.model.Product;
import ch.csbe.productmanagment.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Endpoints for managing products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Creates a new product and associates it with a category.
     */
    @Operation(summary = "Create a new product", description = "Create a new product and associate it with a category")
    @ApiResponse(responseCode = "200", description = "Product created successfully")
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    /**
     * Retrieves a product by its unique ID.
     */
    @Operation(summary = "Get a product by ID", description = "Retrieve a product by its ID")
    @ApiResponse(responseCode = "200", description = "Product retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    /**
     * Returns a list of all products in the system.
     */
    @Operation(summary = "Get all products", description = "Retrieve all products")
    @ApiResponse(responseCode = "200", description = "Products retrieved successfully")
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    /**
     * Updates a product by its ID.
     */
    @Operation(summary = "Update an existing product", description = "Update an existing product")
    @ApiResponse(responseCode = "200", description = "Product updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    /**
     * Deletes a product by its ID.
     */
    @Operation(summary = "Delete a product", description = "Delete a product by ID")
    @ApiResponse(responseCode = "204", description = "Product deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Returns all products belonging to the specified category.
     */
    @Operation(
        summary = "Get products by category ID",
        description = "Retrieve all products that belong to a specific category"
    )
    @ApiResponse(responseCode = "200", description = "Products retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Category not found")
    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.getByCategoryId(categoryId));
    }
}
