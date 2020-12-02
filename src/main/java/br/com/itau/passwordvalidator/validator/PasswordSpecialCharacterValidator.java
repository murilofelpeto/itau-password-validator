package br.com.itau.passwordvalidator.validator;

import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.exception.InvalidPasswordException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Order(5)
public class PasswordSpecialCharacterValidator extends PasswordValidator{

    private static final String INVALID_SPECIAL_CHARACTER = "Your password must contains at least one special character";

    @Override
    public PasswordResponse checkPassword(final String password) {
        if(!hasValidSpecialCharacter(password)) {
            throw new InvalidPasswordException(INVALID_SPECIAL_CHARACTER);
        }
        return hasNext(password);
    }

    private boolean hasValidSpecialCharacter(final String password) {
        final var specialCharacterPattern = Pattern.compile(".*[!@#$%^&*()-+].*");
        return specialCharacterPattern.matcher(password).matches();
    }
}
