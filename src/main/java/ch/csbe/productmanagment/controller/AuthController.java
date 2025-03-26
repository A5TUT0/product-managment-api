package ch.csbe.productmanagment.controller;

import ch.csbe.productmanagment.dto.AuthRequest;
import ch.csbe.productmanagment.dto.AuthResponse;
import ch.csbe.productmanagment.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
