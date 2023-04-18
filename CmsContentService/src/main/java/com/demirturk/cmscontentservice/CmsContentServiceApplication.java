package com.demirturk.cmscontentservice;

import com.demirturk.cmscommons.configuration.CmsCommonsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CmsCommonsConfiguration.class})
public class CmsContentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsContentServiceApplication.class, args);
	}

}
