package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

public class SimMakerRuleTest {
	
	@Test
	public void testSimMakerRuleForNonSamZung() {
		
		SimMakerRule simMakerRule = new SimMakerRule();
		
		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(10002L);
		product.setMaker("Vodafone");
		product.setModel("4G");
		product.setName("Vodafone");
		product.setDescription("This is a 4G Sim.");
		product.setPrice(300);
		product.setCategoryId(ProductCategory.SIM.getCategoryId());

		productList.add(product);

		simMakerRule.applyProductMakerRule(productList);
		
		assertTrue(productList.get(0).getPrice() == 300);
		
	}
	
	@Test
	public void testSimMakerRuleSamZung() {
		
		SimMakerRule simMakerRule = new SimMakerRule();
		
		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(10002L);
		product.setMaker("SamZung");
		product.setModel("4G");
		product.setName("SamZung");
		product.setDescription("This is a 4G Sim.");
		product.setPrice(300);
		product.setCategoryId(ProductCategory.SIM.getCategoryId());

		productList.add(product);

		simMakerRule.applyProductMakerRule(productList);
		
		assertTrue(productList.get(0).getPrice() == 270);
		
	}


}
