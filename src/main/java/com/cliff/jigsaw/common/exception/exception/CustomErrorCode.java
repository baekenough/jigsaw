package com.cliff.jigsaw.common.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {

    USER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "해당하는 유저를 찾을 수 없습니다.", "404"),
    ;
    private final HttpStatus httpStatus;
    private final String message;
    private final String httpCode;

}
