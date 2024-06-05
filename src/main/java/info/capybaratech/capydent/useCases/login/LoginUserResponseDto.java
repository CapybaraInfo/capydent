package info.capybaratech.capydent.useCases.login;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginUserResponseDto {
    private Ulid id;
    private String fullName;
    private String email;
    private Role authority;
    private String username;
}
