package ch.csbe.productmanagment.controller;

import ch.csbe.productmanagment.dto.AuthRequest;
import ch.csbe.productmanagment.dto.AuthResponse;
import ch.csbe.productmanagment.model.User;
import ch.csbe.productmanagment.repository.UserRepository;
import ch.csbe.productmanagment.security.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints for authentication")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Authenticates a user using the provided credentials.
     * Returns a JWT token if authentication is successful.
     */
    @Operation(summary = "Login a user", description = "Authenticate a user and return a JWT token")
    @ApiResponse(responseCode = "200", description = "Login successful")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    /**
     * Registers a new user with default role "USER".
     * The password is securely hashed before persisting.
     */
    @Operation(summary = "Register a new user", description = "Register a new user and store in the database")
    @ApiResponse(responseCode = "200", description = "Registration successful")
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encrypt password
        user.setRoles(Set.of("USER")); // Assign default role
        return ResponseEntity.ok(userRepository.save(user));
    }
}
