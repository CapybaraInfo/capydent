package info.capybaratech.capydent.ultils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import info.capybaratech.capydent.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JwtTokenutils {
    @Value("${smile.jwt.secret}")
    private String jwtSecret;
    @Value("${smile.jwt.duration}")
    private int jwtTokenExpiration;
    @Value("${smile.jwt.refresh-duration}")
    private int jwtRefreshTokenExpiration;


    public String generateTokenForIdentity(String identity) {
        var alg = Algorithm.HMAC256(jwtSecret);
        return JWT.create().withIssuer("SmileServer").withAudience("SmileClient").withExpiresAt(Instant.now().plus(jwtTokenExpiration, ChronoUnit.MINUTES)).withClaim("identity", identity).withIssuedAt(Instant.now()).sign(alg);
    }

    public String validateAndGetIdentity(String token) throws AuthenticationException {
        try {
            var alg = Algorithm.HMAC256(jwtSecret);
            var decoded = JWT.require(alg).withAudience("SmileClient").withIssuer("SmileServer").build().verify(token);
            var claim = decoded.getClaim("identity");
            return claim.asString();
        } catch (Exception ex) {
            throw new AuthenticationException("Token is invalid", ex);
        }

    }


    public String generateNewTokenFromRefresh(String oldToken) throws AuthenticationException {
        var identity = validateAndGetIdentity(oldToken);
        return generateTokenForIdentity(identity);
    }

    public String generateNewRefreshTokenFromRefresh(String oldToken) throws AuthenticationException {
        var identity = validateAndGetIdentity(oldToken);
        return generateRefreshTokenForIdentity(identity);
    }

    public String generateRefreshTokenForIdentity(String identity) {
        var alg = Algorithm.HMAC256(jwtSecret);
        return JWT.create().withIssuer("SmileServer").withAudience("SmileClient").withExpiresAt(Instant.now().plus(jwtRefreshTokenExpiration, ChronoUnit.MINUTES)).withClaim("identity", identity).withIssuedAt(Instant.now()).sign(alg);
    }
}