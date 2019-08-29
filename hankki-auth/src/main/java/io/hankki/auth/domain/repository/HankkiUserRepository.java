package io.hankki.auth.domain.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import io.hankki.auth.domain.entity.HankkiUserEntity;

public interface HankkiUserRepository extends CrudRepository<HankkiUserEntity, String>, QuerydslPredicateExecutor<HankkiUserEntity> {
    
}