package com.productservice.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.productservice.productservice.model.Product;

public interface ProductRepository extends MongoRepository <Product,Integer> {

	
}
