package io.hankki.recipe;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import io.hankki.recipe.domain.model.Recipe;
import io.hankki.recipe.domain.model.RecipeCategoryType;
import io.hankki.recipe.domain.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class HankkiRecipeApplicationTests {

	@Autowired
	RecipeRepository repository;
	
	@Test
	public void contextLoads() {
	}
	@Test
	public void findByRecipeCategoryTypeTest () {
		log.info("findByRecipeCategoryType  START");
		List<Recipe> recipeList = repository.findByRecipeCategoryType(RecipeCategoryType.한식);
		
		for(Recipe recipe: recipeList) {
			log.info(recipe.toString());
		}
		
		assertThat(recipeList.size(), not(0));

		log.info("findByRecipeCategoryType END");
	}
}