package pl.cango.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Zezwala na wszystkie endpointy
                        .allowedOrigins(
                                "http://localhost:3000",  // Dla lokalnego frontendu
                                "https://cangofront.vercel.app" // Dla wersji produkcyjnej na Vercel
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Metody HTTP
                        .allowedHeaders("*") // Pozwala na wszystkie nagłówki
                        .allowCredentials(true); // Wymagane dla zapytań z autoryzacją (cookies)
            }
        };
    }
}
