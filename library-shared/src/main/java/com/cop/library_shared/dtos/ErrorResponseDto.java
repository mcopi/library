package com.cop.library_shared.dtos;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private String error;
    private String message;
}
