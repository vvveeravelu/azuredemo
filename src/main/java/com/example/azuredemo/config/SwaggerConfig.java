package com.example.azuredemo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan
public class SwaggerConfig {

	private static final String _BASE_PACKAGE = "com.example.azuredemo";

	@Bean
	public Docket api() {
	

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(_BASE_PACKAGE))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("App Service REST API", "API to expose the App Items details.", "V1.0",
				"Terms of service", new Contact("App@ets.org", "www.abc.org", "App@ets.org"), "License of API",
				"API license URL", Collections.emptyList());
		return apiInfo;
	}
}

