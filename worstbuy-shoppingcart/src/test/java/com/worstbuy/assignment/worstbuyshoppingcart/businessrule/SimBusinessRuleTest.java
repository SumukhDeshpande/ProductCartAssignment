package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

public class SimBusinessRuleTest {
	
	@Test
	public void testSimRule() {
		SimBusinessRule simBusinessRule= new SimBusinessRule();
		
		List<Product> simList = new ArrayList<Product>();
		Product simProduct = new Product();
		simProduct.setId(10002L);
		simProduct.setMaker("Vodafone");
		simProduct.setModel("4G");
		simProduct.setName("Vodafone");
		simProduct.setDescription("This is a 4G Sim.");
		simProduct.setPrice(300);
		simProduct.setCategoryId(ProductCategory.SIM.getCategoryId());
		simList.add(simProduct);
		
		List<Product> phoneList = new ArrayList<Product>();
		Product phoneProduct = new Product();
		phoneProduct.setId(10001L);
		phoneProduct.setMaker("SamZung");
		phoneProduct.setModel("SamZung-J7-4GLTE");
		phoneProduct.setName("SamZung-J7");
		phoneProduct.setPrice(1000);
		phoneProduct.setDescription("SamZung-4G-latest-phone.");
		phoneProduct.setCategoryId(ProductCategory.PHONE.getCategoryId());
		phoneList.add(phoneProduct);
		
		Product simMasterProduct = new Product();
		simMasterProduct.setId(10002L);
		simMasterProduct.setMaker("Vodafone");
		simMasterProduct.setModel("4G");
		simMasterProduct.setName("Vodafone");
		simMasterProduct.setPrice(300);
		simMasterProduct.setDescription("This is a 4G Sim.");
		simMasterProduct.setCategoryId(ProductCategory.SIM.getCategoryId());
		
		simBusinessRule.processSimOrder(simList, phoneList, simMasterProduct);
		
		assertTrue(simList.size() == 3);
	}
}
