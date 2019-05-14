
package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.bussiness.domain.Product;
import com.example.demo.bussiness.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"../config/applicationContext.xml"})
public class ProductServiceTest {
	@Autowired
	ProductService productService;

	@Test
	public void testFindProduct() {
		Product addProduct = new Product("ホチキス", 100);
		productService.addProduct(addProduct);
		Product findProduct = productService.findByProductName("ホチキス");
		assertThat(findProduct, equalTo(addProduct));
	}
}
