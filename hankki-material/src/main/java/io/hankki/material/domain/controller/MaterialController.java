package io.hankki.material.domain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hankki.material.domain.model.MaterialCategory;
import io.hankki.material.domain.service.MaterialService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MaterialController {
	
	@Autowired
	MaterialService service;
	
	@GetMapping("/api/v1/materialNames")
	public List<String> getMaterialNames(@RequestParam List<Long> materialIdList){
		//List<Long> materialIdList = new ArrayList<Long>();
		//materialIdList.add(1L);
		
		List<String> materialNameList =  service.getMaterialNamesByMaterialIds(materialIdList);
		for(String materialName : materialNameList) {
			log.info(materialName);
		}
		
		return materialNameList;
	}
	
	@GetMapping("/api/v1/materialCategories")
	public List<MaterialCategory> getMaterialCategories(){
		List<MaterialCategory> categoryList = new ArrayList<MaterialCategory>();
		MaterialCategory[] categories = MaterialCategory.values();
		
		for(MaterialCategory category : categories) {
			categoryList.add(category);
		}

		return categoryList;
		
	}

}
