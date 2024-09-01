package app.quantun.langchanin.config.security;

import app.quantun.langchanin.advaices.UnAuthorizedExceptionHandler;
import app.quantun.langchanin.advaices.GlobalExceptionHandlerResponseEntityExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collection;
import java.util.stream.Collectors;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@Slf4j
public class SecurityConfig {





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, GlobalExceptionHandlerResponseEntityExceptionHandler globalExceptionHandler) throws Exception {
        http

                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/**", "/actuator/**", "/v3/**", "/swagger-ui.html", "/swagger-ui*/**", "/swagger-ui/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
                        .authenticationEntryPoint(new UnAuthorizedExceptionHandler())
                        .accessDeniedHandler(new ForbiddenExceptionHandler())

                        )
                .exceptionHandling(exceptions -> {
                    exceptions.accessDeniedHandler(new ForbiddenExceptionHandler());
                    exceptions.authenticationEntryPoint(new UnAuthorizedExceptionHandler());})
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    public JwtAuthenticationConverter jwtAuthenticationConverter() {

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new FirebaseGrantedAuthoritiesConverter());
        return converter;

    }

    private static class FirebaseGrantedAuthoritiesConverter implements Converter<org.springframework.security.oauth2.jwt.Jwt, Collection<GrantedAuthority>> {
        @Override
        public Collection<GrantedAuthority> convert(org.springframework.security.oauth2.jwt.Jwt jwt)

        {
            // Extract roles/claims from the Firebase JWT and map them to GrantedAuthority objects
            // For example:
            Collection<GrantedAuthority> authorities =jwt.getClaimAsStringList("custom_claims").stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

            return authorities;
            //return Collections.emptyList(); // Replace with your logic
        }
    }






}
