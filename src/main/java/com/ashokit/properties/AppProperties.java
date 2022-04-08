package com.ashokit.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lenovo
 *
 */
/**
 * @author Lenovo
 *
 */
/**
 * @author Lenovo
 *
 */
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "app")
@Configuration
public class AppProperties {

	Map<String, String> message = new HashMap<>();

	public AppProperties(Map<String, String> message) {
		this.message = message;
	}

	public AppProperties() {
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AppProperties [message=" + message + "]";
	}

}
