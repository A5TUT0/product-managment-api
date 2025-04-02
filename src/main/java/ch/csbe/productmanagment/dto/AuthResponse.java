package ch.csbe.productmanagment.dto;

/**
 * DTO for authentication responses.
 * Encapsulates the JWT token returned after successful login.
 */
public class AuthResponse {

    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
