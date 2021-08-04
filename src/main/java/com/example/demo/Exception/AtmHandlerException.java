package com.example.demo.Exception;
import org.springframework.http.HttpStatus;

public class AtmHandlerException extends RuntimeException{
    private final int status;
    public AtmHandlerException(int status, String message) {
        super(message);
        this.status = status;
    }

    public AtmHandlerException(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public int getStatus() {
        return status;
    }
}
