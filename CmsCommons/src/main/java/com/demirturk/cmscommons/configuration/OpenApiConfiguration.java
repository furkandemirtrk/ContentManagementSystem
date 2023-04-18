package com.demirturk.cmscommons.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Getter
    @Setter
    @Autowired
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(buildProperties.getArtifact())
                        .description(buildProperties.getName())
                        .version(buildProperties.getVersion())
                );
    }
}
