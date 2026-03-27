package com.io;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * This class is for Open API configuration where we access our Swagger ui from
 * browser
 * 
 * @author Shekar
 */

@Configuration
public class OpenApiConfiguration {

	/**
	 * Method customOpenAPI is customized UI details  
	 * 
	 * @author Shekar
	 */
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(
				new Info().title("Spring Boot Product API").version("1.0").description("This application can perform operations with products"));
	}

}
