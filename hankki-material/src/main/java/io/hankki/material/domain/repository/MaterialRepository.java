package io.hankki.material.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;

import io.hankki.material.domain.model.Material;
import io.hankki.material.domain.model.MaterialCategory;

@RepositoryRestResource
public interface MaterialRepository extends JpaRepository<Material, Long>,
											QueryDslPredicateExecutor<Material>{
	List<Material> findAll(Predicate predicate);
	List<Material> findByMaterialCategory(@Param("materialCategory") MaterialCategory materialCategory);
	

}
