package com.squad_5.recursos.Recursos;
import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class RecursosApplication {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error")))
				.paths(Predicates.not(PathSelectors.regex("/")))
				.paths(PathSelectors.any())
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}
}
