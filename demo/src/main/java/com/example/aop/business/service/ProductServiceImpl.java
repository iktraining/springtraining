package com.example.aop.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.aop.business.domain.Product;

@Component("productServiceImplAop")//demoと衝突するためbyNameで指定した
public class ProductServiceImpl implements ProductService{
	@Autowired
	@Qualifier("productDaoImplAop")
	private ProductDao productDao;

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public Product findByProductName(String name) {
		return productDao.findProduct(name);
	}
}
