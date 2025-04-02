package ch.csbe.productmanagment.repository;

import ch.csbe.productmanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their unique username.
     *
     * @param username the username to search for
     * @return an Optional containing the User if found
     */
    Optional<User> findByUsername(String username);
}
