package com.pragma.retobackend.retobackend.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDto {
    private String email;
    private String password;
}


