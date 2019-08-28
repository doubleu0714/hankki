package io.hankki.material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HankkiMaterialApplication {

	@GetMapping("hello")
	public String hello() {
		return "Hello material service";
	}
	public static void main(String[] args) {
		SpringApplication.run(HankkiMaterialApplication.class, args);
	}

}
