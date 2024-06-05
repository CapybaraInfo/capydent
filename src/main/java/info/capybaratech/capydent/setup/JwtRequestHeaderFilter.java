package info.capybaratech.capydent.setup;

import info.capybaratech.capydent.entities.LoginUser;
import info.capybaratech.capydent.exceptions.AuthenticationException;
import info.capybaratech.capydent.services.impls.LoginServiceImpl;
import info.capybaratech.capydent.ultils.JwtTokenutils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtRequestHeaderFilter extends OncePerRequestFilter {
    private LoginServiceImpl loginService;
    private JwtTokenutils jwtTokenutils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String bearerToken = authHeader.substring(7);
            try {
                String tokenIdentity = jwtTokenutils.validateAndGetIdentity(bearerToken);
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    LoginUser user = (LoginUser) loginService.loadUserByUsername(tokenIdentity);
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (UsernameNotFoundException ignored) {
                // Não propague a exceção, apenas continue com a cadeia de filtros
            }
        }
        filterChain.doFilter(request, response);
    }
}
