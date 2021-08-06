package com.example.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "catalogservice") // Marks the class as a source for configuration properties starting with the prefix "catalogservice"
public class ApplicationProperties {

	/**
	 * A message to welcome users.
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
