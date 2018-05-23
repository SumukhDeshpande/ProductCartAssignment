package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

public class TelevisionMakerRuleTest {
	
	
	@Test
	public void testTelevisionMakerRuleForSamZung() {
		
		TelevisionMakerRule televisionMakerRule = new TelevisionMakerRule();
		
		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(10003L);
		product.setMaker("SamZung");
		product.setModel("LCD");
		product.setName("SamZung");
		product.setDescription("This is a LCD TV.");
		product.setPrice(1000);
		product.setCategoryId(ProductCategory.TELEVISION.getCategoryId());

		productList.add(product);
		
		televisionMakerRule.applyProductMakerRule(productList);
		
		assertTrue(productList.get(0).getPrice() == 900);
		
	}
	
	
	@Test
	public void testTelevisionMakerRuleForNonSamZung() {
		
		TelevisionMakerRule televisionMakerRule = new TelevisionMakerRule();
		
		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(10003L);
		product.setMaker("LG");
		product.setModel("LCD");
		product.setName("LG");
		product.setDescription("This is a LCD TV.");
		product.setPrice(1000);
		product.setCategoryId(ProductCategory.TELEVISION.getCategoryId());

		productList.add(product);

		televisionMakerRule.applyProductMakerRule(productList);
		
		assertTrue(productList.get(0).getPrice() == 1000);
		
	}

}
