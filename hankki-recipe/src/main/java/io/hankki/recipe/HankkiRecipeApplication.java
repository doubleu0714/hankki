package io.hankki.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class HankkiRecipeApplication {

	@GetMapping("hello")
	public String hello() {
		return "Hello recipe service";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HankkiRecipeApplication.class, args);
	}

}
