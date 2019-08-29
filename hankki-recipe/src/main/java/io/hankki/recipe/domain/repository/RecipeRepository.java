package io.hankki.recipe.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hankki.recipe.domain.model.Recipe;
import io.hankki.recipe.domain.model.RecipeCategoryType;
import io.hankki.recipe.domain.model.RecipeMaterial;


@RepositoryRestResource 
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
 	
 	 //1. 카테고리별로 조회하는 쿼리
//	@Query("select a from Recipe a where recipeCategoryType = :recipeCategoryType")
	List<Recipe> findByRecipeCategoryType(@Param("recipeCategoryType") RecipeCategoryType recipeCategoryType);
	
	List<Recipe> findByMaterials_MaterialId(@Param("materialId") Long materialId);
	
	 //2. 식재료 별로 조회하는 쿼리
//	@Query("select a from Recipe a where category = :category")
//	List<Recipe> findBymaterialName (@Param("materialName") String materialName);
	
	 //3. 카테고리와 식재료로 조회하는 쿼리
//	@Query("select a from Recipe a where category = :category and  recipeCategoryType = :recipeCategoryType ")
//	List<Recipe> findBymaterialName (@Param("materialName") String materialName, @Param("recipeCategoryType") RecipeCategoryType recipeCategoryType );

	//4.전체 건 조회
//	@Query("select a from Recipe")
//	List<Recipe> findAll();
	
} 
