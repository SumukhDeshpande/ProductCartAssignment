package com.worstbuy.assignment.worstbuyshoppingcart.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CartTest {
	
	@Test
	public void testObjectCreation() {
		
		Cart cartOne = new Cart();
		Cart cartTwo = new Cart();
		
		Product product = new Product();
		product.setId(10001L);
		product.setMaker("Samsung");
		product.setModel("Samsung-J7-4GLTE");
		product.setName("Samsung-J7");
		product.setPrice(7000);
		product.setDescription("Samsung-4G-latest-phone.");
		product.setCategoryId(1L);
		List<Product> mockProductList = new ArrayList<Product>();
		mockProductList.add(product);
		
		cartOne.setProducts(mockProductList);
		cartOne.setTotalPrice(5000);
		
		Product anotherProduct = new Product();
		anotherProduct.setId(10001L);
		anotherProduct.setMaker("Samsung");
		anotherProduct.setModel("Samsung-J7-4GLTE");
		anotherProduct.setName("Samsung-J7");
		anotherProduct.setPrice(7000);
		anotherProduct.setDescription("Samsung-4G-latest-phone.");
		anotherProduct.setCategoryId(1L);
		List<Product> mockAnotherProductList = new ArrayList<Product>();
		mockAnotherProductList.add(anotherProduct);
		
		cartTwo.setProducts(mockAnotherProductList);
		cartTwo.setTotalPrice(5000);
		
		assertEquals(true, cartOne.equals(cartTwo));
		
		cartTwo.setTotalPrice(10000);
		
		assertEquals(false, cartOne.equals(cartTwo));
		
		
		
	}

}
