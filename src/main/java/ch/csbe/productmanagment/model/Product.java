package ch.csbe.productmanagment.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity representing a product in the system.
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Product name (e.g. "Smartphone")

    private String description; // Optional product description
    private double price;       // Product price

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // Associated category for this product
}
