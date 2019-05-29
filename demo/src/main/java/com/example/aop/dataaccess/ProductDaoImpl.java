package com.example.aop.dataaccess;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.aop.business.domain.Product;
import com.example.aop.business.service.ProductDao;

@Component("productDaoImplAop")
public class ProductDaoImpl implements ProductDao{
	private Map<String, Product> storage = new HashMap<String, Product>();

	@Override
	public Product findProduct(String name) {
		return storage.get(name);
	}

	@Override
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}
}
