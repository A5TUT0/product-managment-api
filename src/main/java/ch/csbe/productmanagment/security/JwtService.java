package ch.csbe.productmanagment.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    // Secret key used for signing the JWT tokens
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token validity duration: 24 hours (in milliseconds)
    private final long EXPIRATION_TIME = 86400000;

    /**
     * Generates a JWT token for a given username.
     *
     * @param username the username to include in the token payload
     * @return the signed JWT token
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date()) // Token creation time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Token expiration
                .signWith(key) // Sign with secret key
                .compact();
    }

    /**
     * Extracts the username (subject) from the given JWT token.
     *
     * @param token the JWT token
     * @return the subject (username) from the token payload
     */
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Validates if the token matches the given username.
     *
     * @param token    the JWT token
     * @param username the expected username
     * @return true if valid, false otherwise
     */
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username);
    }
}
