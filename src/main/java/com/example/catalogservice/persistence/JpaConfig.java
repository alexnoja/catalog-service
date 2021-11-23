package com.example.catalogservice.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // Indicates a class as a source of Spring configuration.
@EnableJpaAuditing // Enables auditing for persistent entities.
public class JpaConfig {

}
