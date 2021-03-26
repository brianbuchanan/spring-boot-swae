package com.fsi.edu.springboot.swae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot entry point
 * 
 * @author bbuchanan
 *
 */
@EnableJpaRepositories(basePackages = {"com.fsi.edu.springboot.swae.dal"})
@SpringBootApplication
@ComponentScan({"com.fsi.edu.springboot.swae"})
@EntityScan("com.fsi.edu.springboot.swae.*")
public class Application {

	/**
	 * Main method to run Spring Boot
	 * 
	 * @param args program arguments (e.g. spring.config.location)
	 */
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
