package br.com.itau.passwordvalidator.configuration;

import br.com.itau.passwordvalidator.validator.PasswordValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
public class PasswordChainConfiguration {

    private final List<PasswordValidator> passwordValidators;

    @Autowired
    public PasswordChainConfiguration(final List<PasswordValidator> passwordValidators) {
        this.passwordValidators = passwordValidators;
    }
}
