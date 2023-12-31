package com.ssafy.goatrip.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
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
	public Docket api() {
		final ApiInfo apiInfo = new ApiInfoBuilder()
				.title("GOATrip API")
				.description("<h3>워크샵에서 사용되는 RestApi에 대한 문서를 제공한다.</h3>")
				.contact(new Contact("3조", "조영진 : tl5235566@gmail.com", "심지연 : 심지연@이메일"))
				.license("MIT License")
				.version("1.0")
				.build();

		
		return new Docket(DocumentationType.SWAGGER_2)		// Swagger 2.0 기반의 문서 작성
				.apiInfo(apiInfo) 							// 문서에 대한 정보를 설정한다.
				.select()									// ApiSelectorBuilder를 반환하며 상세한 설정 처리
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.goatrip.controller"))// 대상으로하는 api 설정
				.paths(PathSelectors.ant("/**/goatrip/**"))	// controller에서 swagger를 지정할 대상 path 설정
				.build();									// Docket 객체 생성			
	}

}
