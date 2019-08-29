package io.hankki.myrecipe.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Myrecipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String userid;
	private String recipeid;
	private String selecteddate;
	
}
