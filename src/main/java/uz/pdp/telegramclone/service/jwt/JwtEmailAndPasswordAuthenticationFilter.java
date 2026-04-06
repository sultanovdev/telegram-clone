package uz.pdp.telegramclone.service.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.telegramclone.dto.auth.LoginRequest;

import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor
public class JwtEmailAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtService jwtService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) {
        try {
            LoginRequest creds = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequest.class);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            creds.email(),
                            creds.password(),
                            new ArrayList<>()
                    );

            return super.getAuthenticationManager().authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse login request", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {

        String token = jwtService.generateToken(authResult);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String tokenResponse = String.format("{\"token\": \"%s\"}", token);
        response.getWriter().write(tokenResponse);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed)
            throws IOException {

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"error\": \"Invalid email or password\"}");
        response.getWriter().flush();

    }

}