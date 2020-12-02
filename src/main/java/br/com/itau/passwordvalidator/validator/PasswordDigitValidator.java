package br.com.itau.passwordvalidator.validator;

import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.exception.InvalidPasswordException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Order(4)
public class PasswordDigitValidator extends PasswordValidator {

    private static final String INVALID_DIGIT = "Your password must contain at least one digit";

    @Override
    public PasswordResponse checkPassword(final String password) {
        if(!hasValidDigit(password)) {
            throw new InvalidPasswordException(INVALID_DIGIT);
        }
        return hasNext(password);
    }

    private boolean hasValidDigit(final String password) {
        final var digitPattern = Pattern.compile(".*\\d.*");
        return digitPattern.matcher(password).matches();
    }
}
