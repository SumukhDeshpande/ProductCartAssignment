package com.worstbuy.assignment.worstbuyshoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void testObjectCreation() {
		Order order = new Order();
		order.setMaker("Samsung");
		order.setModel("Samsung-J7-4GLTE");
		order.setName("Samsung-J7");
		order.setPrice(7000);
		order.setDescription("Samsung-4G-latest-phone.");
		order.setCategoryId(1L);
		
		Order order1 = new Order();
		order1.setMaker("Samsung");
		order1.setModel("Samsung-J7-4GLTE");
		order1.setName("Samsung-J7");
		order1.setPrice(7000);
		order1.setDescription("Samsung-4G-latest-phone.");
		order1.setCategoryId(1L);
		
		assertEquals(order, order1);
		
		order.setPrice(5000);
		
		assertNotEquals(order, order1);
		
	}

}
