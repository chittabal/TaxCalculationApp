package com.chitta.rest.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({ "com.chitta.rest"})
@ComponentScan({ "com.chitta.rest"})
@EnableJpaRepositories(basePackages = {"com.chitta.rest.repo"})
public class TaxCalculationAppApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(TaxCalculationAppApplication.class)
				.properties("spring.config.name:taxcalapplication").build().run(args);
	}

}
