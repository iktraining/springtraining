package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.bussiness.service.ProductServiceImpl;
import com.example.demo.dataaccess.ProductDaoImpl;

@Configuration
public class AppConfig {
	@Bean//参考書ではautowireが使われているが5.1以降非推奨なので使用しない
	public ProductServiceImpl productService() {
		return new ProductServiceImpl();
	}

	@Bean
	public ProductDaoImpl ProductDao() {
		return new ProductDaoImpl();
	}
}
