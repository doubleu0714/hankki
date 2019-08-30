package io.hankki.myrecipe.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;

import io.hankki.myrecipe.domain.model.Myrecipe;

	@RepositoryRestResource
	public interface MyrecipeRepository extends JpaRepository<Myrecipe, Long>,
												QueryDslPredicateExecutor<Myrecipe>{
		Myrecipe findById(@Param("id") Long id);
		List<Myrecipe> findByUserid(@Param("userid") String userid);
		List<Myrecipe> findAll(Predicate predicate);
		List<Myrecipe> findByUseridLike(@Param("userid") String userid);
	}