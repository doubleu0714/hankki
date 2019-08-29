package io.hankki.material.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
//public class RepositoryRestConfig implements RepositoryRestConfigurer { //2.1 이상
//RepositoryRestConfigurerAdapter는 Deprecated 됨. RepositoryRestConfigurer를 직접 구현하는 것으로 가이드 됨.
public class RepositoryRestConfig extends RepositoryRestConfigurerAdapter { //1.5.20

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType())
				.collect(Collectors.toList()).toArray(new Class[0]));
	}
}
