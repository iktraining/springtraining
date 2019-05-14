package com.example.demo.bussiness.service;

import com.example.demo.bussiness.domain.Product;

public interface ProductDao {
	void addProduct(Product product);
	Product findByProductName(String name);
}
