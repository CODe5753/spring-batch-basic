package com.example.demo.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseType {

    // common
    SUCCESS(HttpStatus.OK, "success"),
    FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, "server error");


    private final HttpStatus httpStatus;
    private final String message;
}
