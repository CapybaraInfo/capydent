package info.capybaratech.capydent.useCases.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RefreshTokenResponseDto {
    String accessToken;
    String refreshToken;
}
