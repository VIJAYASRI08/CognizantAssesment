package com.example.jwt.controller;

import com.example.jwt.service.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authManager, JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtService.generateToken(username);
    }
    
}
