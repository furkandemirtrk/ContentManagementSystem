package com.demirturk.cmscommons.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ModelMapperConfiguration.class, OpenApiConfiguration.class})
public class CmsCommonsConfiguration {
}
