package io.hankki.material.domain.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import io.hankki.material.HankkiMaterialApplicationTests;
import io.hankki.material.domain.repository.MaterialRepository;
import io.hankki.material.domain.service.MaterialService;
import io.hankki.material.domain.service.impl.MaterialServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialControllerTest {
	@Autowired
    protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	
	 @Before
	    public void setup() throws Exception {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }


	@Test
    public void getMaterialNamesTest() throws Exception {
        final ResultActions actions = mockMvc.perform(get("/api/v1/materialNames")
        								 .param("materialIdList", "1,2")
						                 .contentType(MediaType.APPLICATION_JSON_UTF8))
						                 .andDo(print());
        actions.andExpect(MockMvcResultMatchers.status().isOk());
        
    }
	
	@Test
    public void getMaterialCategoriesTest() throws Exception {
        final ResultActions actions = mockMvc.perform(get("/api/v1/materialCategories")
						                 .contentType(MediaType.APPLICATION_JSON_UTF8))
						                 .andDo(print());
        actions.andExpect(MockMvcResultMatchers.status().isOk());
        
        
    }

}
