package br.com.itau.passwordvalidator.validator;

import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import br.com.itau.passwordvalidator.exception.InvalidPasswordException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
@Order(3)
public class PasswordDuplicateCharacterValidator extends PasswordValidator{
    private static final String DUPLICATE_CHARACTER = "Your password has duplicated characters";

    @Override
    public PasswordResponse checkPassword(final String password) {
        if(hasDuplicateCharacter(password)) {
            throw new InvalidPasswordException(DUPLICATE_CHARACTER);
        }

        return hasNext(password);
    }

    private boolean hasDuplicateCharacter(final String password) {
        final var trimmedPassword = password.trim();
        final var passwordLetters = trimmedPassword.toCharArray();

        Set<Character> characterSet = new LinkedHashSet<>();

        for(var letter : passwordLetters) {
            if(!characterSet.add(letter)) {
                return true;
            }
        }
        return false;
    }
}
