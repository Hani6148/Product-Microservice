package com.productservice.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productservice.productservice.model.Product;
@Repository
public interface ProductRepository extends MongoRepository <Product,Integer> {

	
}
