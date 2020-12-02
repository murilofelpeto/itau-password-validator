package br.com.itau.passwordvalidator.controller;

import br.com.itau.passwordvalidator.dto.request.PasswordRequest;
import br.com.itau.passwordvalidator.dto.response.PasswordResponse;

public interface PasswordValidatorController {

    PasswordResponse isValid(PasswordRequest password);
}
