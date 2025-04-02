package ch.csbe.productmanagment.controller;

import ch.csbe.productmanagment.model.User;
import ch.csbe.productmanagment.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creates a new user with a default role.
     */
    @Operation(summary = "Create a new user", description = "Register a new user with a default role")
    @ApiResponse(responseCode = "200", description = "User created successfully")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    /**
     * Retrieves a user by ID.
     */
    @Operation(summary = "Get a user by ID", description = "Retrieve a user by their ID")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    /**
     * Retrieves all users.
     */
    @Operation(summary = "Get all users", description = "Retrieve all users")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    /**
     * Updates an existing user's details.
     */
    @Operation(summary = "Update an existing user", description = "Update the details of an existing user")
    @ApiResponse(responseCode = "200", description = "User updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    /**
     * Deletes a user by ID.
     */
    @Operation(summary = "Delete a user", description = "Delete a user by ID")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Promotes a user to admin role if not already assigned.
     */
    @Operation(summary = "Promote a user to admin", description = "Promote a user to an admin role")
    @ApiResponse(responseCode = "204", description = "User promoted successfully")
    @PutMapping("/promote/{id}")
    public ResponseEntity<Void> promote(@PathVariable Long id) {
        userService.promoteToAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
