package com.cliff.jigsaw.common.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {

    CustomErrorCode errorCode;


}
