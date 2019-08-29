package io.hankki.recipe.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hankki.recipe.domain.model.Recipe;


@RepositoryRestResource 
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
 	
 	 
 } 
