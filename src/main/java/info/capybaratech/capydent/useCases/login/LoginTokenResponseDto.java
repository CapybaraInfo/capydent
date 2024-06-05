package info.capybaratech.capydent.useCases.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginTokenResponseDto {
    private String acessToken;
    private String refreshToken;
    private LoginUserResponseDto userData;
}
