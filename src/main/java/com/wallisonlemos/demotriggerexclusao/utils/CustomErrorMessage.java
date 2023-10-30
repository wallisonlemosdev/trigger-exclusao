package com.wallisonlemos.demotriggerexclusao.utils;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomErrorMessage {
    private String message;
    private LocalDateTime timestamp;

    public CustomErrorMessage(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}