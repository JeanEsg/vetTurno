package com.jeanEsguerra.vetTurno.controller;

import com.jeanEsguerra.vetTurno.dto.AuthResponse;
import com.jeanEsguerra.vetTurno.dto.LoginRequest;
import com.jeanEsguerra.vetTurno.dto.RegistroRequest;
import com.jeanEsguerra.vetTurno.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService s){ this.authService = s; }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegistroRequest req){
        return authService.registrar(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req){
        return authService.login(req);
    }
}
