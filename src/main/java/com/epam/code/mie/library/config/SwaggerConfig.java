package com.epam.code.mie.library.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder().group("Library Management System")
        .packagesToScan("com.epam.code.mie.library").build();
  }
}