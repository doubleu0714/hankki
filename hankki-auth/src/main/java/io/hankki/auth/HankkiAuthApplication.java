package io.hankki.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableZuulProxy
public class HankkiAuthApplication {

	@GetMapping("/api/auth/hello")
	public String hello() {
		return "Hello auth service";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HankkiAuthApplication.class, args);
	}

}
