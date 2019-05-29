package com.example.demo.dataaccess;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.bussiness.domain.Product;
import com.example.demo.bussiness.service.ProductDao;

@Component
@Scope("prototype")
public class ProductDaoImpl implements ProductDao {
	private Map<String, Product> storage = new HashMap<String, Product>();

	@Override
	public void addProduct(Product product) {
		storage.put(product.getName(), product);
	}
	@Override
	public Product findByProductName(String name) {
		return storage.get(name);
	}
}
