package io.hankki.material.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hankki.material.domain.model.Material;
import io.hankki.material.domain.repository.MaterialRepository;
import io.hankki.material.domain.service.MaterialService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	MaterialRepository repository;

	@Override
	public List<String> getMaterialNamesByMaterialIds(List<Long> materialIds) {
		List<String> materialNameList = new ArrayList<String>();
		List<Material> materialList = repository.findByMaterialIdIn(materialIds);
		
		for(Material material : materialList) {
			materialNameList.add(material.getMaterialName());
			log.info(material.toString());
		}
		
		
		return materialNameList;
	}

}
