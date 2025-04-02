package ch.csbe.productmanagment.service;

import ch.csbe.productmanagment.model.User;
import ch.csbe.productmanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * Implementation of the UserService interface for handling user-related operations.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a user without additional validation.
     */
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates user data by ID.
     */
    @Override
    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        existing.setRoles(user.getRoles());
        return userRepository.save(existing);
    }

    /**
     * Deletes a user by ID.
     */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Retrieves a user by ID or throws if not found.
     */
    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
    }

    /**
     * Retrieves all users from the database.
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Registers a new user and assigns a default "USER" role if none is provided.
     */
    @Override
    public User register(User user) {
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(new HashSet<>());
            user.getRoles().add("USER");
        }
        return userRepository.save(user);
    }

    /**
     * Promotes a user to the "ADMIN" role if they don't already have it.
     */
    @Override
    public void promoteToAdmin(Long userId) {
        User user = getById(userId);
        if (!user.getRoles().contains("ADMIN")) {
            user.getRoles().add("ADMIN");
            userRepository.save(user);
        }
    }

    /**
     * Retrieves a user by their username or throws if not found.
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
