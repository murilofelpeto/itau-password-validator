package br.com.itau.passwordvalidator.service;


import br.com.itau.passwordvalidator.dto.request.PasswordRequest;
import br.com.itau.passwordvalidator.dto.response.PasswordResponse;

public interface PasswordValidatorService {

    PasswordResponse isValid(PasswordRequest password);
}
