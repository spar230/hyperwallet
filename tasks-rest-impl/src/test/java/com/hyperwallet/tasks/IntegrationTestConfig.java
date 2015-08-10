package com.hyperwallet.tasks;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.hyperwallet.tasks")
@EnableAutoConfiguration
@EnableConfigurationProperties
@PropertySource("classpath:test.properties")
public class IntegrationTestConfig {
}
