package io.hankki.recipe.category;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import io.hankki.recipe.domain.model.Recipe;
import io.hankki.recipe.domain.model.RecipeCategory;
//import io.hankki.recipe.domain.model.RecipeCategoryType;
import io.hankki.recipe.domain.repository.RecipeCategoryRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HankkiRecipeCategoryApplicationTests {

//	@Autowired
//	RecipeCategoryRepository repositorycategory;
	
	@Test
	public void contextLoads() {
	}
//	@Test
//	public void findByRecipeCategoryTest () {
//		log.info("findByRecipeCategoryName  START");
//
//		//String RecipeCategoryName="한식";
//		List<RecipeCategory> recipeList = repositorycategory.findByRecipeCategoryName("한식");
//		
//		for(RecipeCategory recipe: recipeList) {
//			log.info(recipe.toString());
//		}
//		
//		assertThat(recipeList.size(), not(0));
//
//		log.info("findByRecipeCategoryName END");
//	}
}