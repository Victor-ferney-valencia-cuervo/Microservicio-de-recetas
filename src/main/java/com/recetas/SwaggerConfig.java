package com.recetas;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("🍽️ Recetas API")
                        .version("1.0.0")
                        .description("Microservicio REST de recetas colombianas. " +
                                     "Datos en memoria, sin base de datos. " +
                                     "Listo para consumir desde React u otras aplicaciones.")
                        .contact(new Contact()
                                .name("Recetas Service")
                                .email("contacto@recetas.com")));
    }
}
