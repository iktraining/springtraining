package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bussiness.domain.Product;
import com.example.demo.bussiness.service.ProductService;


public class ProductSampleRun {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ProductSampleRun productSampleRun = new ProductSampleRun();
		productSampleRun.execute();
	}

	@SuppressWarnings("resource")
	public void execute() {
		BeanFactory ctx = new ClassPathXmlApplicationContext(
				"/com/example/config/applicationContext.xml");
		ProductService productService = ctx.getBean(ProductService.class);

		productService.addProduct(new Product("ホチキス", 100));

		Product product = productService.findByProductName("ホチキス");
		System.out.println(product);
	}
}