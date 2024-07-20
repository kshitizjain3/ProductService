package com.scalar.productservicejune24.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(){
        ResponseEntity<String> response = new ResponseEntity<>(
                "Arithmetic Exception has happened", HttpStatus.NOT_FOUND
        );
                return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBound Exception has happened", HttpStatus.NOT_FOUND
        );
        return response;
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerExceptionException() {
        ResponseEntity<String> response = new ResponseEntity<>(
                "NullPointerException Exception has happened", HttpStatus.NOT_FOUND
        );
        return response;
    }
}
