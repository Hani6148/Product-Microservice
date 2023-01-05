package com.productservice.productservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.dto.ProductResponse;
import com.productservice.productservice.model.Product;
import com.productservice.productservice.repository.ProductRepository;
import com.productservice.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepo;

	@Override
	public void createProduct(ProductRequest productRequest) {
		
		
		
		Product product = Product.builder()
				.name(productRequest.getName())
				.price(productRequest.getPrice())
				.desc(productRequest.getDesc())
				.quantity(productRequest.getQuantity())
				.build();
		productRepo.save(product);
		
		log.info("product is saved");
		
		  
	}

	@Override
	public List <ProductResponse> getAllProducts() {
		 List<Product> products=productRepo.findAll();
		return  products.stream().map(this::mapResponse).toList();
		 
	}
	
	public ProductResponse mapResponse(Product product) {
		
		 
			 return ProductResponse.builder()
					 .id(product.getId())
					 .desc(product.getDesc())
					 .name(product.getName())
					 .price(product.getPrice())
					 .quantity(product.getQuantity())
					 .build();
		 
	}

}
