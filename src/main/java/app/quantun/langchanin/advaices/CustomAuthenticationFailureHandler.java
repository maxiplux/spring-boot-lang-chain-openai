package app.quantun.langchanin.advaices;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
@Component
public class CustomAuthenticationFailureHandler
        implements AuthenticationEntryPoint {

    private ObjectMapper objectMapper = new ObjectMapper();





    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/problem+json");

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "Access denied due to missing or invalid authentication token.");
        problemDetail.setTitle("Authorization Error");
        problemDetail.setType(URI.create("https://local.com/error"));
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        problemDetail.setProperty("exceptionType", "MissingAuthenticationTokenException");
        problemDetail.setProperty("timestamp", LocalDateTime.now().toString());



        response.getOutputStream()
                .println(objectMapper.writeValueAsString(problemDetail));
    }
}
