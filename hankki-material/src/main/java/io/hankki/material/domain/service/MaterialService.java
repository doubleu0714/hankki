package io.hankki.material.domain.service;

import java.util.List;

public interface MaterialService {
	
	List<String> getMaterialNamesByMaterialIds(List<Long> materialIds);

}
