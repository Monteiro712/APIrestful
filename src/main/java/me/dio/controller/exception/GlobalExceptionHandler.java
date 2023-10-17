package me.dio.controller.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //private final Logger logger = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handeBusinessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException){
        return new ResponseEntity<>("resource ID not found", HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnExpectedException(Throwable unExpectedException){
        var messege = "unexpected server error, see the logs";
        Logger.getLogger(messege, String.valueOf(unExpectedException));
        return new ResponseEntity<>(messege, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
