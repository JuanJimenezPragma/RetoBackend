package com.pragma.retobackend.retobackend.infrastructure.input.rest.controller;

import com.pragma.retobackend.retobackend.application.dto.request.CuentaRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.CuentaResponseDto;
import com.pragma.retobackend.retobackend.application.handler.ICuentaHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cuenta")
@RestController
@RequiredArgsConstructor
public class CuentaRestController {

    private final ICuentaHandler cuentaHandler;

    @PostMapping
    public ResponseEntity<Void> crearCuenta(@RequestBody CuentaRequestDto cuentaRequestDto){
        cuentaHandler.save(cuentaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/create-employed")
    public ResponseEntity<Void> createEmployed(@RequestBody CuentaRequestDto cuentaRequestDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cuentaHandler.createEmployeed(cuentaRequestDto, ((UserDetails) principal).getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/create-client")
    public ResponseEntity<Void> createClient(@RequestBody CuentaRequestDto cuentaRequestDto){
        cuentaHandler.createClient(cuentaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CuentaResponseDto>> obtenerCuentas(){
        return new ResponseEntity<>(cuentaHandler.obtenerCuentas(),HttpStatus.OK);
    }

}
