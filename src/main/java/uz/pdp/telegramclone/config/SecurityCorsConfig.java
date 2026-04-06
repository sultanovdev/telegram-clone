package uz.pdp.telegramclone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityCorsConfig {

    @Autowired
    private Environment environment;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);

        String allowedOrigins = environment.getProperty("spring.web.cors.allowed-origins",
                environment.getProperty("CORS_ALLOWED_ORIGINS", "http://localhost:3001"));

        List<String> originPatterns = getStrings(allowedOrigins);

        config.setAllowedOriginPatterns(originPatterns);
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        config.setAllowedHeaders(List.of("*"));
        config.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    private static List<String> getStrings(String allowedOrigins) {
        List<String> origins = new ArrayList<>();
        if (!allowedOrigins.isEmpty()) {
            String[] originsArray = allowedOrigins.split(",");
            for (String origin : originsArray) {
                String trimmed = origin.trim();
                if (!trimmed.isEmpty()) {
                    origins.add(trimmed);
                }
            }
        }
        if (!origins.contains("http://localhost:3001")) {
            origins.add("http://localhost:3001");
        }
        List<String> originPatterns = new ArrayList<>();
        for (String origin : origins) {
            if (origin.contains("localhost")) {
                originPatterns.add("http://localhost:*");
            } else {
                originPatterns.add(origin);
            }
        }
        return originPatterns;
    }
}
