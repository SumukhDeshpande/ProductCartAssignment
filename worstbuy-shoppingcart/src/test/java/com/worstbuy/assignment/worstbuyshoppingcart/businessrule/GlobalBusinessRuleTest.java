package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public class GlobalBusinessRuleTest {
	
	@Test
	public void testGlobalBusinessRule() {
		GlobalBusinessRule globalBusinessRule = new GlobalBusinessRule();
		List<Product> productList = new ArrayList<Product>();
		
		Product product = new Product();
		product.setId(10001L);
		product.setMaker("Samsung");
		product.setModel("Samsung-J7-4GLTE");
		product.setName("Samsung-J7");
		product.setPrice(100);
		product.setDescription("Samsung-4G-latest-phone.");
		product.setCategoryId(1L);
		
		productList.add(product);
		
		globalBusinessRule.applyCommonBusinessRule(productList);
		
		assertTrue(productList.get(0).getPrice()==114.0);
		
	}

}
