package io.hankki.recipe.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class RecipeCategory  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long recipeCategoryId;
	private String recipeCategoryName;
//	private String recommendCategory;
	
	
	
//	
//	public recipe(String recipeId, String recipeName, recipeCategoryType recipeCategoryType, Long cookingTime,  Long calory) { 
//		 		this.recipeId 			= recipeId; 
//		 		this.recipeName 		= recipeName; 
//		 		this.recipeCategoryType = recipeCategoryType;
//		 		this.cookingTime 		= cookingTime; 
//		 		this.calory			 	= calory; 
//		 
//		 	} 

}
