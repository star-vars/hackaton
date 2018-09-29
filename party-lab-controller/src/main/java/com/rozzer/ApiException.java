package com.rozzer;

import org.springframework.http.ResponseEntity;

public class ApiException extends RuntimeException {
    private final ResponseEntity<?> responseEntity;

    public ApiException(ResponseEntity<?> responseEntity) {
        this.responseEntity = responseEntity;
    }

    @Override
    public String getMessage() {
        return "API response entity: [" + responseEntity + "]";
    }
}
