package io.hankki.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HankkiAuthApplicationTests {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void passwordEncoder테스트() {
		System.out.println(passwordEncoder.encode("1111"));
	}	

}
