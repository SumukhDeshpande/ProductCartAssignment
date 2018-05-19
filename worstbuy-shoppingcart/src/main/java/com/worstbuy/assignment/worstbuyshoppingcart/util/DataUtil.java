package com.worstbuy.assignment.worstbuyshoppingcart.util;

import java.util.ArrayList;
import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Order;
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
		for (Product product : productList) {
			finalPrice = finalPrice + product.getPrice();
		}
		return finalPrice;
	}

	public static double calculateDiscount(double productPrice, double discountToBeApplied) {
		return productPrice - (productPrice * discountToBeApplied);
	}

	public static boolean checkProductIsInsuranceOrFree(Product product) {

		if (product.getCategoryId() == ProductCategory.INSURANCE.getCategoryId() || product.getPrice() == 0) {
			return true;
		}
		return false;
	}
	
	public static Product getNewInsuranceProduct(Product insuranceProduct, double discount) {
		Product insuranceProductToAdd = new Product();
		insuranceProductToAdd.setCategoryId(ProductCategory.INSURANCE.getCategoryId());
		insuranceProductToAdd.setPrice(calculateDiscount(insuranceProduct.getPrice(), discount));
		insuranceProductToAdd.setDescription(insuranceProduct.getDescription());
		insuranceProductToAdd.setMaker(insuranceProduct.getMaker());
		insuranceProductToAdd.setName(insuranceProduct.getName());
		insuranceProductToAdd.setModel(insuranceProduct.getModel());
		insuranceProductToAdd.setId(insuranceProduct.getId());
		
		return insuranceProductToAdd;
	}
	
	public static List<Order> translateProductToOrder(List<Product> products){
		List<Order> orderList = new ArrayList<Order>();
		
		for(Product product : products) {
			Order order = new Order();
			order.setCategoryId(product.getCategoryId());
			order.setDescription(product.getDescription());
			order.setMaker(product.getMaker());
			order.setModel(product.getModel());
			order.setName(product.getName());
			order.setPrice(product.getPrice());
			orderList.add(order);
		}
		
		return orderList;
	}

}
