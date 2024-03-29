package io.hankki.material;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import io.hankki.material.domain.model.Material;
import io.hankki.material.domain.model.MaterialCategory;
import io.hankki.material.domain.repository.MaterialRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HankkiMaterialApplicationTests {
	
	@Autowired
	MaterialRepository repository;
	

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void findByMaterialCategoryTest() {
		log.info("findByMaterialCategoryTest START");
		List<Material> materialList = repository.findByMaterialCategory(MaterialCategory.양념);
		for(Material material: materialList) {
			log.info(material.toString());
		}
		assertThat(materialList.size(), not(0));
		
		log.info("findByMaterialCategoryTest END");
	}

}
