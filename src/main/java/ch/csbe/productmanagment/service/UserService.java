package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.User;

import java.util.List;

/**
 * Service interface for managing user operations.
 */
public interface UserService {

    /**
     * Creates a new user (without validation or password hashing).
     */
    User create(User user);

    /**
     * Updates an existing user's data.
     */
    User update(Long id, User user);

    /**
     * Deletes a user by ID.
     */
    void delete(Long id);

    /**
     * Retrieves a user by their ID.
     */
    User getById(Long id);

    /**
     * Retrieves all users in the system.
     */
    List<User> getAll();

    /**
     * Registers a new user with default role(s).
     */
    User register(User user);

    /**
     * Promotes a user to admin role if not already assigned.
     */
    void promoteToAdmin(Long userId);

    /**
     * Finds a user by their username.
     */
    User findByUsername(String username);
}
