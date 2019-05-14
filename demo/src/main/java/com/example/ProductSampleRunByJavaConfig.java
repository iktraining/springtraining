package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.demo.bussiness.domain.Product;
import com.example.demo.bussiness.service.ProductService;

//ProductSampleRunのJavaConfigを使用しての記述
public class ProductSampleRunByJavaConfig {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ProductSampleRunByJavaConfig productSampleRunByJavaConfig = new ProductSampleRunByJavaConfig();
		productSampleRunByJavaConfig.execute();
	}

	@SuppressWarnings("resource")
	public void execute() {
		//アノテーションを使用した場合
		//BeanFactory ctx = new ClassPathXmlApplicationContext("/com/example/config/applicationContext.xml");

		//JavaConfigを使用した場合
		//参考書では左辺がApplicationContextとなっているが5.1では右辺からの変換ができないため
		//AnnotationConfigApplicationContextを使用している
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService productService = applicationContext.getBean(ProductService.class);

		productService.addProduct(new Product("ホチキス", 100));

		Product product = productService.findByProductName("ホチキス");
		System.out.println(product);
	}
}
