package io.hankki.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HankkiAuthApplication {

	@GetMapping("hello")
	public String hello() {
		return "Hello auth service";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HankkiAuthApplication.class, args);
	}

}
