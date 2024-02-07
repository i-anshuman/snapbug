package com.snapbug.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

  @Value("${openapi.scheme.name}")
  private String schemeName;

  @Value("${openapi.bearer.format}")
  private String bearerFormat;

  @Value("${openapi.security.scheme}")
  private String securityScheme;

  @Value("${openapi.info.title}")
  private String title;

  @Value("${openapi.info.description}")
  private String description;

  @Value("${openapi.info.version}")
  private String version;

  @Value("${openapi.info.contact.name}")
  private String contactName;

  @Value("${openapi.info.contact.email}")
  private String contactEmail;

  @Value("${openapi.info.contact.url}")
  private String contactUrl;

  @Value("${openapi.info.license.name}")
  private String licenseName;

  @Value("${openapi.info.license.url}")
  private String licenseUrl;

  @Bean
  public OpenAPI configure() {
    return new OpenAPI()
            .addSecurityItem(new SecurityRequirement().addList(schemeName))
            .components(new Components().addSecuritySchemes(schemeName, apiKeyScheme()))
            .info(getApiInfo());
  }

  private SecurityScheme apiKeyScheme() {
    return new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .bearerFormat(bearerFormat)
            .scheme(securityScheme);
  }

  private Info getApiInfo() {
    return new Info()
            .title(title)
            .description(description)
            .version(version)
            .contact(
              new Contact()
               .name(contactName)
               .email(contactEmail)
               .url(contactUrl)
            )
            .license(
              new License()
               .name(licenseName)
               .url(licenseUrl)
            );
  }
}
