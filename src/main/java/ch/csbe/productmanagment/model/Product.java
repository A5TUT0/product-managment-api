package ch.csbe.productmanagment.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
