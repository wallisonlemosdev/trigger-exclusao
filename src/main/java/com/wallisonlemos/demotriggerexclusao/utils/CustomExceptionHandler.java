package com.wallisonlemos.demotriggerexclusao.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<CustomErrorMessage> handleDataIntegrityViolation(JpaSystemException ex) {
        CustomErrorMessage error = new CustomErrorMessage(extrairMessagemErro(ex.getRootCause().getMessage()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static String extrairMessagemErro(String message) {
        int errorIndex = message.indexOf("ERROR:");

        if (errorIndex >= 0) {
            int finalIndex = message.indexOf("\n", errorIndex);
            if (finalIndex >= 0) {
                return message.substring(errorIndex + "ERROR: ".length(), finalIndex).trim();
            }
        }

        return message;
    }

}
