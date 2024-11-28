package com.study.backendaws.global;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "BASIC BOARD API",
        version = "v1"
    )
)
public class SwaggerConfig implements WebMvcConfigurer {

}
