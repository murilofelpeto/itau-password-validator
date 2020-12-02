package br.com.itau.passwordvalidator.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
@Getter
@Setter
public class PasswordResponse {

    private final Boolean isValid;
}
