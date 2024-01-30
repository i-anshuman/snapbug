package com.snapbug.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages.properties")
@PropertySource("classpath:security.properties")
public class PropertiesConfiguration {
}
