package de.telran.urlshortener.configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Обозначает класс как источник конфигурации бинов.
@Configuration//
    public class OpenApiConfig {

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                    .info(new Info().title("UrlShortener project"))
                    .addSecurityItem(new SecurityRequirement()
                            .addList("Bearer Authentication"))
                    .components(new Components()
                            .addSecuritySchemes("Bearer Authentication",jwtSecurityScheme()));

        }

        private SecurityScheme jwtSecurityScheme() {
            return new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .bearerFormat("JWT")
                    .scheme("bearer");
        }
}
