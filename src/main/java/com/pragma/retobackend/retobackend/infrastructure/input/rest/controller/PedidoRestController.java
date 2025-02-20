package com.pragma.retobackend.retobackend.infrastructure.input.rest.controller;

import com.pragma.retobackend.retobackend.application.dto.request.PedidoRequestDto;
import com.pragma.retobackend.retobackend.application.dto.response.PedidoResponseDto;
import com.pragma.retobackend.retobackend.application.handler.IPedidoHandler;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RequestMapping("/pedido")
@RestController
@RequiredArgsConstructor
public class PedidoRestController {
    private final IPedidoHandler pedidoHandler;

    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";


    @PostMapping
    public ResponseEntity<Void> createPedido(@RequestBody PedidoRequestDto pedidoRequestDto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        pedidoHandler.save(pedidoRequestDto, ((UserDetails) principal).getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PedidoResponseDto>> getPedidos(@RequestBody PedidoRequestDto pedidoRequestDto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<PedidoResponseDto> pedidoList =
                pedidoHandler.getByStatus(pedidoRequestDto.getEstado(), pedidoRequestDto.getPageRequestDto().getPage(),
                        pedidoRequestDto.getPageRequestDto().getSize(),
                        ((UserDetails) principal).getUsername());
        return new ResponseEntity<>(pedidoList, HttpStatus.OK);
    }

    @PostMapping("/asign")
    public ResponseEntity<List<PedidoResponseDto>> asignPedido(@RequestBody PedidoRequestDto pedidoRequestDto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<PedidoResponseDto> pedidoList =
                pedidoHandler.pedidoAsign(pedidoRequestDto.getId(),
                        pedidoRequestDto.getEstado(),
                        pedidoRequestDto.getPageRequestDto().getPage(),
                        pedidoRequestDto.getPageRequestDto().getSize(),
                        ((UserDetails) principal).getUsername());

        return new ResponseEntity<>(pedidoList, HttpStatus.OK);
    }

    @PostMapping("/ready")
    public ResponseEntity<Void> pedidoReady() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(
                new PhoneNumber("+573004938018"),
                new PhoneNumber("+17754027215"),
                "Tu pedido ya esta listo!"
        ).create();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
