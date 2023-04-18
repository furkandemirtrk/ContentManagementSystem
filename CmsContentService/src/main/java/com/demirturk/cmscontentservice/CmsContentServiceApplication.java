package com.demirturk.cmscontentservice;

import com.demirturk.cmscommons.configuration.CmsCommonsConfiguration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CmsCommonsConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "Cms Content Service", version = "1.0", description = "Cms Content Service"))
public class CmsContentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsContentServiceApplication.class, args);
	}

}
