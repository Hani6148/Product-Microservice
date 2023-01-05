package com.productservice.productservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(value="product")
public class Product {

	private int id;
	private String name;
	private String desc;
	private int quantity;
	private float price;
}
