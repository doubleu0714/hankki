package io.hankki.myrecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class HankkiMyrecipeApplication {

	@GetMapping("hello")
	public String hello() {
		return "Hello myrecipe service";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HankkiMyrecipeApplication.class, args);
	}

}
