package app.quantun.langchanin.advaices;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

@Component
@Slf4j
public class UnAuthorizedExceptionHandler implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info( "Unauthorized error: {}", authException.getMessage());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/problem+json");

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, authException.getLocalizedMessage());
        problemDetail.setTitle("Authorization Error");
        problemDetail.setType(URI.create("https://local.com/error"));
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        problemDetail.setProperty("exceptionType",  authException.getLocalizedMessage());
        problemDetail.setProperty("timestamp", LocalDateTime.now().toString());


        response.getOutputStream()
                .println(objectMapper.writeValueAsString(problemDetail));
    }
}
