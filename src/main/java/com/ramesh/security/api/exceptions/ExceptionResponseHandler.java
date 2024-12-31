package com.ramesh.security.api.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ExceptionResponseHandler.class);

    @ExceptionHandler(value = {UserNotFoundException.class})
   public ResponseEntity<Object> handleUserNotFoundException(RuntimeException ex) {
        logIt(ex);
        return new ResponseEntity<Object>("User not found", HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(value = AccessDeniedException.class)
   public ResponseEntity<Object> handleAccessDeniedException(RuntimeException ex) {
       logIt(ex);
        return new ResponseEntity<Object>("Access Denied", HttpStatus.UNAUTHORIZED);
   }

   @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleGenericExceptions(RuntimeException ex) {
       logIt(ex);
        return new ResponseEntity<Object>("Unable to process the action", HttpStatus.INTERNAL_SERVER_ERROR);
   }

   private void logIt(RuntimeException ex) {
        logger.error(ex.getMessage(), ex);
   }
}
