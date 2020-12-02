package br.com.itau.passwordvalidator.service.implementation;

import br.com.itau.passwordvalidator.configuration.PasswordChainConfiguration;
import br.com.itau.passwordvalidator.dto.request.PasswordRequest;
import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.service.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PasswordValidatorServiceImpl implements PasswordValidatorService {

    private final PasswordChainConfiguration chainConfiguration;

    @Autowired
    public PasswordValidatorServiceImpl(final PasswordChainConfiguration chainConfiguration) {
        this.chainConfiguration = chainConfiguration;
    }

    @Override
    public PasswordResponse isValid(final PasswordRequest password) {
        return chainConfiguration
                .getPasswordValidators()
                .stream()
                .map(chain -> chain.checkPassword(password.getPassword()))
                .collect(Collectors.toList())
                .stream()
                .findFirst()
                .get();

    }
}
