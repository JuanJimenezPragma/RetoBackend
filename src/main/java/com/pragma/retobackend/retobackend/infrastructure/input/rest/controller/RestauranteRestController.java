package com.pragma.retobackend.retobackend.infrastructure.input.rest.controller;

import com.pragma.retobackend.retobackend.application.dto.request.PageRequestDto;
import com.pragma.retobackend.retobackend.application.dto.request.RestauranteRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.RestauranteResponseDto;
import com.pragma.retobackend.retobackend.application.handler.IRestauranteHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restaurante")
@RestController
@RequiredArgsConstructor
public class RestauranteRestController {

    private final IRestauranteHandler restauranteHandler;

    @PostMapping()
    public ResponseEntity<String> createRestaurant(@RequestBody RestauranteRequestDto restaurante){
        restauranteHandler.save(restaurante);
        return new ResponseEntity<>("bien hecho", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RestauranteResponseDto>> obtenerTodos(@RequestBody PageRequestDto pageRequest){
        return new ResponseEntity<>(restauranteHandler.getAll(pageRequest.getPage(), pageRequest.getSize()), HttpStatus.OK);
    }

}
