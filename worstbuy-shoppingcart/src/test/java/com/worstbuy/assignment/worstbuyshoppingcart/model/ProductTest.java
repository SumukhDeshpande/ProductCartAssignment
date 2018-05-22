package com.worstbuy.assignment.worstbuyshoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

public class ProductTest {

	@Test
	public void testProductObjectCreation() {
		Product phoneCase = new Product();
		phoneCase.setId(10004L);
		phoneCase.setMaker("Phone Case");
		phoneCase.setModel("Some Phone Case");
		phoneCase.setName("Plastic");
		phoneCase.setPrice(100);
		phoneCase.setDescription("This is a Plastic Phone Case.");
		phoneCase.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());
		
		Product phoneCase1 = new Product();
		phoneCase1.setId(10004L);
		phoneCase1.setMaker("Phone Case");
		phoneCase1.setModel("Some Phone Case");
		phoneCase1.setName("Plastic");
		phoneCase1.setPrice(100);
		phoneCase1.setDescription("This is a Plastic Phone Case.");
		phoneCase1.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());
		
		assertEquals(phoneCase, phoneCase1);
		
		phoneCase1.setModel("Silicon phone case.");
		
		assertNotEquals(phoneCase, phoneCase1);
	}

}
