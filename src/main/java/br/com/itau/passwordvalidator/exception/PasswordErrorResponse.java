package br.com.itau.passwordvalidator.exception;

import lombok.Getter;

import java.util.Date;

@Getter
public class PasswordErrorResponse {

    private Date timestamp;
    private Boolean isValid;
    private String message;

    public PasswordErrorResponse(final Date timestamp, final Boolean isValid, final String message) {
        this.timestamp = timestamp;
        this.isValid = isValid;
        this.message = message;
    }
}
