package io.hankki.recipe.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

import lombok.Data;

@Data
@Entity
public class RecipeMaterial {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId", 
    foreignKey = @ForeignKey(name = "FK_RECIPE_MATERIAL"))
    private Recipe recipe;
	
	private Long materialId;
	
	private Boolean mandantory;
	
	
	
}
