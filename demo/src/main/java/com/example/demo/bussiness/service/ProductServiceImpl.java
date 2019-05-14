package com.example.demo.bussiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bussiness.domain.Product;

@Component
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public Product findByProductName(String name) {
		return productDao.findByProductName(name);
	}
}
