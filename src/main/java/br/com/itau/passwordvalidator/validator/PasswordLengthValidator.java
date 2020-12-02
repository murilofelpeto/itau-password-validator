package br.com.itau.passwordvalidator.validator;

import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.exception.InvalidPasswordException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PasswordLengthValidator extends PasswordValidator{

    private static final String INVALID_PASSWORD_LENGTH = "Your password must contain at least 9 characters";

    public PasswordResponse checkPassword(final String password) {
        if(password.length() < 9 || !StringUtils.isNotBlank(password)) {
            throw new InvalidPasswordException(INVALID_PASSWORD_LENGTH);
        }
        return hasNext(password);
    }
}
