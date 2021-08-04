package com.example.demo.dto;

import java.time.LocalDateTime;


public class ErrorInfoDTO {
    private int code;
    private String message;
    private LocalDateTime timestamp;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
