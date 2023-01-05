package com.productservice.productservice.service;

import java.util.List;

import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.dto.ProductResponse;

public interface ProductService {

	public void createProduct( ProductRequest productRequest);
	public List<ProductResponse> getAllProducts ();
}
