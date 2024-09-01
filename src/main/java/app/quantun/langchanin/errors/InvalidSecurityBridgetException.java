package app.quantun.langchanin.errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidSecurityBridgetException extends RuntimeException {
    public InvalidSecurityBridgetException(String message) {
        super(message);
    }

    public InvalidSecurityBridgetException(String message, Throwable cause) {
        super(message, cause);
    }
}
