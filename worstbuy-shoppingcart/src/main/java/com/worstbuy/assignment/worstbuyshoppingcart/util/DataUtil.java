package com.worstbuy.assignment.worstbuyshoppingcart.util;

import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public final class DataUtil {
	
	private DataUtil() {
		
	}

	public static Product getFreePhone() {

		Product product = new Product();
		product.setMaker("Samsung");
		product.setModel("Samsung-J7-4GLTE");
		product.setName("Samsung-J7");
		product.setPrice(0);
		product.setDescription("Samsung-4G-latest-phone.");
		product.setCategoryId(ProductCategory.PHONE.getCategoryId());

		return product;
	}
	
	public static Product getFreeSim() {

		Product product = new Product();
  		product.setMaker("Vodafone");
		product.setModel("4GLTE");
		product.setName("Vodafone");
		product.setPrice(0);
		product.setDescription("Vodafone SIM card.");
		product.setCategoryId(ProductCategory.SIM.getCategoryId());

		return product;
	}
	
	public static double getTotalPrice(List<Product> productList) {
		double finalPrice = 0;
		for(Product product : productList) {
			finalPrice = finalPrice + product.getPrice();
		}
		return finalPrice;
	}

}
