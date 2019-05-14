package com.example.aop.business.service;

import com.example.aop.business.domain.Product;

public interface ProductDao {
	void addProduct(Product product);

	Product findProduct(String name);
}
