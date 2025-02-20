package com.pragma.retobackend.retobackend.infrastructure.input.rest.controller;

import com.pragma.retobackend.retobackend.application.dto.request.PlatoRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.PlatoResponseDto;
import com.pragma.retobackend.retobackend.application.handler.PlatoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/plato")
@RestController
@RequiredArgsConstructor
public class PlatoController {

    private final PlatoHandler platoHandler;

    @PostMapping
    public ResponseEntity<Void> crearPlato(@RequestBody PlatoRequestDto platoRequest){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        platoHandler.save(platoRequest,((UserDetails) principal).getUsername());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatoResponseDto> actualizarPlato(@PathVariable Long id, @RequestBody PlatoRequestDto platoRequestDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PlatoResponseDto plato = platoHandler.update(id, platoRequestDto, ((UserDetails) principal).getUsername());
        return new ResponseEntity<>(plato,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PlatoResponseDto>> obtenerPlatos(@RequestBody PlatoRequestDto platoRequestDto) {
        return new ResponseEntity<>(platoHandler.getAll(platoRequestDto.getPageable().getPage(),platoRequestDto.getPageable().getSize(),platoRequestDto.getCategoria()),HttpStatus.OK);
    }

    @PatchMapping("/{idPlato}")
    public ResponseEntity<Void> changueStatus(@PathVariable Long idPlato, @RequestBody PlatoRequestDto platoRequestDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        platoHandler.changueStatus(idPlato,platoRequestDto.getEstado(), ((UserDetails) principal).getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
