package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

public class PhoneMakerRuleTest {

	@Test
	public void testPhoneMakerBusinessRuleForSamZung() {

		PhoneMakerRule phoneMakerBusinessRule = new PhoneMakerRule();

		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(10001L);
		product.setMaker("SamZung");
		product.setModel("SamZung-J7-4GLTE");
		product.setName("SamZung-J7");
		product.setPrice(1000);
		product.setDescription("SamZung-4G-latest-phone.");
		product.setCategoryId(1L);

		productList.add(product);

		phoneMakerBusinessRule.applyProductMakerRule(productList);
		
		assertTrue(productList.get(0).getPrice() == 900);

	}
	
	
	@Test
	public void testPhoneMakerBusinessRuleForNonSamZungProduct() {

		PhoneMakerRule phoneMakerBusinessRule = new PhoneMakerRule();

		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(10001L);
		product.setMaker("LG");
		product.setModel("LG-J7-4GLTE");
		product.setName("LG-J7");
		product.setPrice(1000);
		product.setDescription("LG-4G-latest-phone.");
		product.setCategoryId(1L);

		productList.add(product);

		phoneMakerBusinessRule.applyProductMakerRule(productList);
		
		assertTrue(productList.get(0).getPrice() == 1000);

	}
	
	

}
