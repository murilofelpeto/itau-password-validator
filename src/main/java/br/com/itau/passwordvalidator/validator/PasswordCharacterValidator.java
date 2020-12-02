package br.com.itau.passwordvalidator.validator;

import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.exception.InvalidPasswordException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Order(2)
public class PasswordCharacterValidator  extends PasswordValidator {

    private static final String INVALID_CHARACTER = "Your password must contain one uppercase letter and one lowercase letter";

    public PasswordResponse checkPassword(final String password) {
        if(!hasValidCharacter(password)) {
            throw new InvalidPasswordException(INVALID_CHARACTER);
        }
        return hasNext(password);

    }

    private boolean hasValidCharacter(final String password) {
        final var upperCasePattern = Pattern.compile(".*[A-Z].*");
        final var lowerCasePattern = Pattern.compile(".*[a-z].*");
        return upperCasePattern.matcher(password).matches() && lowerCasePattern.matcher(password).matches();
    }
}
