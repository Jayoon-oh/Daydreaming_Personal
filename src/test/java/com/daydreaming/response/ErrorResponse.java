package com.daydreaming.response;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * "code" : "400";
 * "message" : "잘못된 요청입니다."
 * "validation" : {
 *     "title" : "값을 요청해주세요."
 * }
 *
 */

@Getter
public class ErrorResponse {

    private final String code;
    private final String message;
    private final Map<String, Object> validation = new HashMap<>();

    @Builder
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void addValidation(String fieldName, String errorMessage) {
        this.validation.put(fieldName, errorMessage);
    }

}
