package info.capybaratech.capydent.useCases.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginUserDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
