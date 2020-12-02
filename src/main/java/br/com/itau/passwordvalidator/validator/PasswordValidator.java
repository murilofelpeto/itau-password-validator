package br.com.itau.passwordvalidator.validator;

import br.com.itau.passwordvalidator.dto.response.PasswordResponse;
import org.springframework.stereotype.Component;

@Component
public abstract class PasswordValidator {

    private PasswordValidator next;

    public PasswordValidator linkWith(final PasswordValidator next) {
        this.next = next;
        return next;
    }

    public abstract PasswordResponse checkPassword(String password);

    protected final PasswordResponse hasNext(String password){
        if(next == null) {
            return PasswordResponse.of(true);
        }
        return next.hasNext(password);
    }
}
