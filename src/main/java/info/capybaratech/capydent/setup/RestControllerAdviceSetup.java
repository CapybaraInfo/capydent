package info.capybaratech.capydent.setup;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import info.capybaratech.capydent.exceptions.AuthenticationException;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.messages.ErrorMessage;
import info.capybaratech.capydent.messages.FieldValidationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestControllerAdviceSetup {
    private static final Logger log = LoggerFactory.getLogger(RestControllerAdviceSetup.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidations(final MethodArgumentNotValidException th) {
        final BindingResult bindingResult = th.getBindingResult();
        final List<FieldValidationMessage> errors = bindingResult.getFieldErrors().stream().map(e -> FieldValidationMessage.builder().message(e.getDefaultMessage()).field(e.getField()).build()).collect(Collectors.toList());
        final ErrorMessage errorMessage = ErrorMessage.builder().details("Um ou mais campos estão inválidos").title("Ocorreu um erro na requisição").validationMessages(errors).status(HttpStatus.BAD_REQUEST.value()).type(HttpStatus.BAD_REQUEST.name()).issueAt(OffsetDateTime.now()).build();
        log.debug("Erro de validação", th);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorMessage> handleGenericError(final Throwable th) {
        final ErrorMessage defaultErrorResponseDto = ErrorMessage.builder().details("Ocorreu um erro interno no servidor, fale com o suporte!").title("Falha catastrófica").type(HttpStatus.INTERNAL_SERVER_ERROR.name()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).issueAt(OffsetDateTime.now()).build();
        log.error("Falha catastrófica detectada", th);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(defaultErrorResponseDto);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<ErrorMessage> handleMethodNotAllowed(final HttpRequestMethodNotSupportedException th) {
        final ErrorMessage defaultErrorResponseDto = ErrorMessage.builder().details("O método informado na requisição está inválido").title("Método inválido").type(HttpStatus.METHOD_NOT_ALLOWED.name()).status(HttpStatus.METHOD_NOT_ALLOWED.value()).issueAt(OffsetDateTime.now()).build();
        log.debug("Método inválido", th);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(defaultErrorResponseDto);
    }

    @ExceptionHandler({JWTDecodeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleBadToken(final Throwable th) {
        final ErrorMessage errorMessage = ErrorMessage.builder().details(th.getMessage()).title("Requisição inválida").type(HttpStatus.BAD_REQUEST.name()).status(HttpStatus.BAD_REQUEST.value()).issueAt(OffsetDateTime.now()).build();
        log.warn("Token inválido", th);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleNotFound(final Throwable th) {
        final ErrorMessage errorMessage = ErrorMessage.builder().details(th.getMessage()).title("Erro no recurso").type(HttpStatus.NOT_FOUND.name()).status(HttpStatus.NOT_FOUND.value()).issueAt(OffsetDateTime.now()).build();
        log.warn("Recurso inválido", th);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler({UsernameNotFoundException.class, AuthenticationException.class, BadCredentialsException.class, InternalAuthenticationServiceException.class, TokenExpiredException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessage> handleUnauthenticated(final Throwable th) {
        final ErrorMessage defaultErrorResponseDto = ErrorMessage.builder().details("Ocorreu um erro na autorização, credenciais inválidas").title("Não autenticado").type(HttpStatus.UNAUTHORIZED.name()).status(HttpStatus.UNAUTHORIZED.value()).issueAt(OffsetDateTime.now()).build();
        log.debug("Não autenticado", th);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(defaultErrorResponseDto);
    }
}
