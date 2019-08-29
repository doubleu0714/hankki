package io.hankki.myrecipe;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.hankki.myrecipe.domain.model.Myrecipe;
import io.hankki.myrecipe.domain.repository.MyrecipeRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HankkiMyrecipeApplicationTests {

	@Autowired
	MyrecipeRepository repository;
	
	@Test
	public void findByMyrecipesTest() {
		log.info("findByMyrecipesTest START");
		List<Myrecipe> myrecipeList = repository.findAll();
		for(Myrecipe myrecipe: myrecipeList) {
			log.info(myrecipe.toString());
		}
		assertThat(myrecipeList.size(), not(0));
		
		log.info("findByMaterialCategoryTest END");
	}

}
