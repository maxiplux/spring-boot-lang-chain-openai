package app.quantun.langchanin.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

@Component
@Slf4j
public class ForbiddenExceptionHandler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,

                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info( "Unauthorized error: {}", accessDeniedException.getMessage());


        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/problem+json");

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, accessDeniedException.getMessage());
        problemDetail.setTitle("Authorization Error");
        problemDetail.setType(URI.create("https://local.com/error"));
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        problemDetail.setProperty("exceptionType", "MissingAuthenticationTokenException");
        problemDetail.setProperty("timestamp", LocalDateTime.now().toString());


        response.getOutputStream()
                .println(objectMapper.writeValueAsString(problemDetail));
    }


}
