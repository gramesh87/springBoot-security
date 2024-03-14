package com.ramesh.security.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
   public ResponseEntity<Object> handleUserNotFoundException(RuntimeException ex) {
        return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(value = AccessDeniedException.class)
   public ResponseEntity<Object> handleAccessDeniedException(RuntimeException ex) {
        return new ResponseEntity<Object>("Access Denied", HttpStatus.UNAUTHORIZED);
   }
}
