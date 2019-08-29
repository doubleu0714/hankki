package io.hankki.material.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Material {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long materialId;
	
	private String materialName;
	@Enumerated(EnumType.STRING)
	private MaterialCategory materialCategory;
}
