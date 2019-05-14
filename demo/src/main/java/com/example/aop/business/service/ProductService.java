package com.example.aop.business.service;

import com.example.aop.business.domain.Product;

public interface ProductService {
	void addProduct(Product product);
	Product findByProductName(String name);
}
