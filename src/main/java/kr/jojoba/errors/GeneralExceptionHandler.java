package kr.jojoba.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

import static kr.jojoba.utils.ApiUtil.ApiResult;
import static kr.jojoba.utils.ApiUtil.error;

@RestControllerAdvice
public class GeneralExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    public ResponseEntity<ApiResult<?>> newResponse(HttpStatus status, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");

        return new ResponseEntity<>(error(status, message), headers, status);
    }

    public ResponseEntity<ApiResult<?>> newResponse(HttpStatus status, Throwable throwable) {
        return newResponse(status, throwable.getMessage());
    }

    @ExceptionHandler({
            NoHandlerFoundException.class,
            NotFoundException.class
    })
    public ResponseEntity<?> handlerNotFoundException(Exception e) {
        return newResponse(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            IllegalStateException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<?> handlerBadRequestException(Exception e) {
        logger.error("Bad request exception occurred: {}", e);

        if (e instanceof MethodArgumentNotValidException) {
            return newResponse(HttpStatus.BAD_REQUEST, ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }

        return newResponse(HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handlerMethodNotAllowedException(Exception e) {
        logger.error("Method not allowed exception occurred: {}", e);
        return newResponse(HttpStatus.METHOD_NOT_ALLOWED, e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handlerUncheckedException(Exception e) {
        logger.error("Unchecked exception occurred: {}", e);
        return newResponse(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }
}
