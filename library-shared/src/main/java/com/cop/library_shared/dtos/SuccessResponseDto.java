package com.cop.library_shared.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponseDto<T> {
    private T data;
    private String message;

    public SuccessResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
