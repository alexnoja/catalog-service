package com.example.catalogservice;

//import static org.springframework.web.servlet.function.RequestPredicates.GET;
//import static org.springframework.web.servlet.function.RouterFunctions.route;
//import static org.springframework.web.servlet.function.ServerResponse.ok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;

//import com.example.catalogservice.config.ApplicationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(ApplicationProperties.class) // tell Spring Boot to load configuration data beans in the application context from ApplicationProperties
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

//	@Bean
//	RouterFunction<ServerResponse> routes(ApplicationProperties properties) {
//		return route(GET("/"), request -> ok().body(properties.getMessage()));
//	}
}
