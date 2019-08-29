package io.hankki.material.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.hankki.material.domain.model.Material;

@RepositoryRestResource
public interface MaterialRepository extends JpaRepository<Material, Long>{
	
	

}
