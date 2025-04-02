package ch.csbe.productmanagment.security;

import ch.csbe.productmanagment.dto.AuthRequest;
import ch.csbe.productmanagment.dto.AuthResponse;
import ch.csbe.productmanagment.model.User;
import ch.csbe.productmanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    // Used for password hashing and verification
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Authenticates the user by verifying the credentials and generates a JWT token.
     *
     * @param request the authentication request with username and password
     * @return AuthResponse containing the generated JWT token
     */
    public AuthResponse authenticate(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate password against hashed value in database
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token on successful authentication
        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
