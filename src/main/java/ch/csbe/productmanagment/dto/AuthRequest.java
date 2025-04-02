package ch.csbe.productmanagment.dto;

/**
 * DTO for authentication requests.
 * Used to receive login and registration credentials from the client.
 */
public class AuthRequest {

    private String username;
    private String password;

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
