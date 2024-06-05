package info.capybaratech.capydent.controllers;

import info.capybaratech.capydent.entities.LoginUser;
import info.capybaratech.capydent.exceptions.AuthenticationException;
import info.capybaratech.capydent.ultils.JwtTokenutils;
import info.capybaratech.capydent.useCases.login.LoginTokenResponseDto;
import info.capybaratech.capydent.useCases.login.LoginUserDto;
import info.capybaratech.capydent.useCases.login.LoginUserMapper;
import info.capybaratech.capydent.useCases.login.RefreshTokenResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Authentication")
@RequestMapping(path = "/api/login")
@AllArgsConstructor
public class LoginController {
    private AuthenticationManager authenticationManager;
    private JwtTokenutils jwtTokenutils;
    private LoginUserMapper mapper;

    @PostMapping
    @Operation(summary = "Perform user authentication and get access token")
    public LoginTokenResponseDto login(@RequestBody @Valid LoginUserDto loginUser) throws AuthenticationException {

        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        var user = (LoginUser) auth.getPrincipal();
        if (auth.isAuthenticated()) {
            var token = jwtTokenutils.generateTokenForIdentity(user.getUsername());
            var refreshToken = jwtTokenutils.generateRefreshTokenForIdentity(user.getId().toString());
            var userResponseDto = mapper.toLoginUserResponseDto(user);
            return new LoginTokenResponseDto(token, refreshToken, userResponseDto);
        }
        throw new AuthenticationException("Credenciais inválidas");

    }

    @GetMapping(path = "/refresh-token/{token}")
    @Operation(summary = "Get a new access token from refresh token")
    public RefreshTokenResponseDto refreshToken(@PathVariable String token) {
        var newToken = jwtTokenutils.generateNewTokenFromRefresh(token);
        var newRefreshToken = jwtTokenutils.generateNewRefreshTokenFromRefresh(token);
        return new RefreshTokenResponseDto(newToken, newRefreshToken);
    }

}
