package com.zinopay.membership;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Membership API",
                version = "0.0.1",
                description = "Membership API"
        )
)
@Configuration
public class SwaggerConfig {

}