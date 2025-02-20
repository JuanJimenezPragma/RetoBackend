package com.pragma.retobackend.retobackend.infrastructure.input.rest.controller;

import com.pragma.retobackend.retobackend.application.dto.request.AuthRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.AuthResponse;
import com.pragma.retobackend.retobackend.application.dto.response.CuentaResponseDto;
import com.pragma.retobackend.retobackend.application.handler.ICuentaHandler;
import com.pragma.retobackend.retobackend.infrastructure.input.rest.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final ICuentaHandler cuentaHandler;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login( @RequestBody AuthRequestDto authRequest) {
        CuentaResponseDto cuenta = cuentaHandler.obtenerCuentaByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtService.generateToken(cuenta.getCorreo(),cuenta.getRol().name());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
