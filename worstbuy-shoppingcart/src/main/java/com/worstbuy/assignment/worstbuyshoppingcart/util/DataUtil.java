package com.worstbuy.assignment.worstbuyshoppingcart.util;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.PHONE_INSURANCE_DISCOUNT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.PRODUCT_PRICE;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.PRODUCT_PRICE_RELATED_INSURANCE_DISCOUNT;

import java.util.ArrayList;
import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Order;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public final class DataUtil {

	private DataUtil() {

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
	
	public static Product getFreePhoneCase() {
		
		Product product = new Product();
		product.setMaker("ABC Plastics");
		product.setModel("For all models.");
		product.setName("Phone Plastic Case");
		product.setPrice(0);
		product.setDescription("Phone case for all the SIMs.");
		product.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());

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
	
	public static Product getInsuranceForPhone(Product phoneMasterDetails, Product insuranceProduct) {
		
		double discount = 0;
		
		if(phoneMasterDetails.getPrice() > PRODUCT_PRICE) {
			discount = PRODUCT_PRICE_RELATED_INSURANCE_DISCOUNT;
		}
		
		if(phoneMasterDetails.getPrice() < PRODUCT_PRICE) {
			discount = PHONE_INSURANCE_DISCOUNT;
		}
		
		return getNewInsuranceProduct(insuranceProduct, discount);
		
	}
	
	public static Product getInsuranceForSim(Product simMasterDetails, Product insuranceProduct) {
		double discount = 0;
		return getNewInsuranceProduct(insuranceProduct, discount);
	}
	
	public static Product getInsuranceForPhoneCase(Product phoneCaseMasterDetails, Product insuranceProduct) {
		double discount = 0;
		return getNewInsuranceProduct(insuranceProduct, discount);
	}
	
	public static Product getInsuranceForTv(Product tvMasterDetails, Product insuranceProduct) {
		double discount = 0;
		return getNewInsuranceProduct(insuranceProduct, discount);
	}

}
