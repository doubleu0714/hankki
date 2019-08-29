package io.hankki.auth.domain.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {
	
	   @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .apiInfo(apiInfo()).select()
	          .apis(RequestHandlerSelectors.basePackage("io.hankki.auth.domain.controller"))              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	   
	   private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("한끼 Auth API")
	                .description("한끼 Auth API를 사용해 봅시다.")
	                .build();
	 
	    }

}
