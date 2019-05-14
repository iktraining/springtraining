package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.aop.business.domain.Product;
import com.example.aop.business.service.ProductService;

public class ProductSampleRunAopAnnotation {

	public static void main(String[] args) {
		ProductSampleRunAopAnnotation productSampleRunAA = new ProductSampleRunAopAnnotation();
		productSampleRunAA.execute();
	}

	@SuppressWarnings("resource")
	public void execute() {
		BeanFactory ctx = new ClassPathXmlApplicationContext("/com/example/config/applicationContext.xml");
		ProductService productService = ctx.getBean(ProductService.class);

		productService.addProduct(new Product("ホチキス", 100));

		Product product = productService.findByProductName("ホチキス");
		System.out.println(product);

	}
}
