package pl.cango.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // all paths
                .allowedOrigins("http://localhost:3000") // front end url
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // allowed http requests
                .allowedHeaders("*") // allow to all types of headers
                .allowCredentials(true); // allow cookies?
    }
}
