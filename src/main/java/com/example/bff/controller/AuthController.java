package com.example.bff.controller;

import com.example.bff.dto.*;
import com.example.bff.service.AuthService;
import com.example.bff.exception.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest req) {
        try {
            return ResponseEntity.ok(authService.signup(req));
        } catch (Exception e) {
            throw new AuthenticationException("Failed to sign up: " + e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest req) {
        try {
            return ResponseEntity.ok(authService.signin(req));
        } catch (Exception e) {
            throw new AuthenticationException("Failed to sign in: " + e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponseDto> logout(@RequestBody LogoutDto req) {
        try {
            return ResponseEntity.ok(authService.logout(req));
        } catch (Exception e) {
            throw new AuthenticationException("Failed to logout: " + e.getMessage());
        }
    }
}
