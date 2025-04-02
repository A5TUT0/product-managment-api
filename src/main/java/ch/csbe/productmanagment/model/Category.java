package ch.csbe.productmanagment.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a product category.
 */
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Category name (e.g. "Electronics", "Books")
}
