package com.pragma.retobackend.retobackend.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto {
    private int page;
    private int size;
}
