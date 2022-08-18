package com.example.demo.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseDto<T> {

    HttpStatus httpStatus;
    String message;
    T data;

    public ResponseDto() {
    }

    public ResponseDto(HttpStatus httpStatus, String message, T data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseDto<T> success() {
        ResponseType type = ResponseType.SUCCESS;
        return new ResponseDto<>(type.getHttpStatus(), type.getMessage(), null);
    }

    public static <T> ResponseDto<T> success(T data) {
        ResponseType type = ResponseType.SUCCESS;
        return new ResponseDto<>(type.getHttpStatus(), type.getMessage(), data);
    }
}
