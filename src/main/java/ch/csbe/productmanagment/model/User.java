package ch.csbe.productmanagment.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

/**
 * Entity representing an application user.
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username; // Unique identifier for login

    @Column(nullable = false)
    private String password; // Hashed password

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private Set<String> roles; // List of roles (e.g. USER, ADMIN)
}
