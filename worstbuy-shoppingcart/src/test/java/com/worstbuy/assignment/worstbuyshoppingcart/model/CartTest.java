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
		
		Order order = new Order();
		order.setMaker("Samsung");
		order.setModel("Samsung-J7-4GLTE");
		order.setName("Samsung-J7");
		order.setPrice(7000);
		order.setDescription("Samsung-4G-latest-phone.");
		order.setCategoryId(1L);
		List<Order> mockProductList = new ArrayList<Order>();
		mockProductList.add(order);
		
		cartOne.setOrders(mockProductList);
		cartOne.setTotalPrice(5000);
		
		Order anotherOrder = new Order();
		anotherOrder.setMaker("Samsung");
		anotherOrder.setModel("Samsung-J7-4GLTE");
		anotherOrder.setName("Samsung-J7");
		anotherOrder.setPrice(7000);
		anotherOrder.setDescription("Samsung-4G-latest-phone.");
		anotherOrder.setCategoryId(1L);
		List<Order> mockAnotherProductList = new ArrayList<Order>();
		mockAnotherProductList.add(anotherOrder);
		
		cartTwo.setOrders(mockAnotherProductList);
		cartTwo.setTotalPrice(5000);
		
		assertEquals(true, cartOne.equals(cartTwo));
		
		cartTwo.setTotalPrice(10000);
		
		assertEquals(false, cartOne.equals(cartTwo));
		
		
		
	}

}
