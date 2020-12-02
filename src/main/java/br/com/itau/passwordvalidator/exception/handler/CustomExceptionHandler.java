package br.com.itau.passwordvalidator.exception.handler;

import br.com.itau.passwordvalidator.exception.InvalidPasswordException;
import br.com.itau.passwordvalidator.exception.PasswordErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public final ResponseEntity<PasswordErrorResponse> handleResourceNotFound(Exception exception, WebRequest webRequest) {
        final var response = new PasswordErrorResponse(new Date(), false, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
