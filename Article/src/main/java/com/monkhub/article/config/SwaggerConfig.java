package com.monkhub.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket articleApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo("Article")).groupName("Article-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.monkhub.article.controller")).build();
	}

	private ApiInfo apiInfo(String pType) {
		return new ApiInfoBuilder().title(pType + " API").description(pType + " API for developers")
				.termsOfServiceUrl("https://" + pType.toLowerCase() + ".com")
				.contact(new Contact(pType + " API", "https://" + pType.toLowerCase() + ".com",
						pType.toLowerCase() + "@gmail.com"))
				.license(pType + " License").licenseUrl("https://" + pType.toLowerCase() + ".com").version("1.0")
				.build();
	}

}
