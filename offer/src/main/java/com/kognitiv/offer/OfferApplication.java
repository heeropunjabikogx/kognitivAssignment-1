package com.kognitiv.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class OfferApplication {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OfferApplication.class);

	}
	public static void main(String[] args) {
		SpringApplication.run(OfferApplication.class, args);
	}

}
