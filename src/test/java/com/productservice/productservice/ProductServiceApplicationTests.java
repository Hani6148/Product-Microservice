package com.productservice.productservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dto.ProductRequest;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	@Autowired
	MockMvc mockMvc;
	
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		
		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
		
	}
	@BeforeAll
	static void initAll() {
		mongoDBContainer.start();
	}
	
	@Test
	void createProduct() throws Exception {
		ProductRequest productRequest = productRequestMaker();
		String productRequestString= objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
		.andExpect(status().isCreated());
		
		 
	}
	
	
	private ProductRequest productRequestMaker() {
		
		return ProductRequest.builder()
				.name("Puma")
				.desc("running shoes")
				.price(65)
				.quantity(100)
				.build(); 
	} 

}
