package br.com.itau.passwordvalidator.controller.implementation;

import br.com.itau.passwordvalidator.controller.PasswordValidatorController;
import br.com.itau.passwordvalidator.dto.request.PasswordRequest;
import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.service.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordControllerImpl implements PasswordValidatorController {

    private final PasswordValidatorService passwordValidatorService;

    @Autowired
    public PasswordControllerImpl(final PasswordValidatorService passwordValidatorService) {
        this.passwordValidatorService = passwordValidatorService;
    }

    @Override
    @PostMapping("/isValid")
    public PasswordResponse isValid(@RequestBody final PasswordRequest password) {
        return passwordValidatorService.isValid(password);
    }
}
