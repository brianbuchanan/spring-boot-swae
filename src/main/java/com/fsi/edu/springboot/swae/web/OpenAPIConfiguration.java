package com.fsi.edu.springboot.swae.web;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Open API Configuration for DRep
 * 
 * @author bbuchanan
 *
 */
@Configuration
public class OpenAPIConfiguration {

	private static final String TITLE = "FSI Education: Spring Boot Software Architecture Example";
	
	/**
	 * {@link OpenAPI} bean
	 * 
	 * @param buildInfo build information
	 * @return the Open API bean
	 */
	@Bean
	public OpenAPI openAPI(BuildProperties buildInfo) {
		return new OpenAPI().info(new Info().title(TITLE).version(buildInfo.getVersion()));
	}
}
