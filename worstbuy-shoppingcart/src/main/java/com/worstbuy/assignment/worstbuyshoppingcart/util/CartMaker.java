package com.worstbuy.assignment.worstbuyshoppingcart.util;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.translateProductToOrder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.GlobalRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.InsuranceRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.PhoneCaseRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.ProductMakerRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.SimRule;
import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.validator.SimValidator;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.CART_SUCCESSFUL_MESSAGE;

@Component
public class CartMaker {

	@Autowired
	SimValidator simValidator;
	
	@Autowired
	SimRule simBusinessRule;
	
	@Autowired
	PhoneCaseRule phoneCaseBusinessRule;
	
	@Autowired
	ProductMakerRule phoneCaseMakerRule;
	
	@Autowired
	ProductMakerRule phoneMakerRule;
	
	@Autowired
	ProductMakerRule simMakerRule;
	
	@Autowired
	ProductMakerRule televisionMakerRule;
	
	@Autowired
	InsuranceRule insuranceBusinessRule;
	
	@Autowired
	GlobalRule globalBusinessRule;

	public Cart createCart(List<Product> productListInput, List<Product> productMasterList) throws ValidationException {

		List<Product> phoneList = getPhoneList(productListInput);
		List<Product> tvList = getTvList(productListInput);
		List<Product> phoneCaseList = getPhoneCaseList(productListInput);
		List<Product> simList = getSimList(productListInput);
		
		List<Product> productInputListCopy = new ArrayList<>();
		
		productInputListCopy.addAll(productListInput);
		
		//Business Rule: The law prevents anyone buying more than 10 SIM cards in a single purchase.
		
		simValidator.validateSim(simList);
		
		//Business Rule: One Sim card is added for free for each phone sold.
		//Business Rule: SimCard sold on their own(not with the phone) are "Buy one get One Free".
		simBusinessRule.processSimOrder(simList, phoneList);
		
		//Business Rule: There is a "Buy 3 get 4" on phone cases.
		if(!phoneCaseList.isEmpty()) {
			phoneCaseBusinessRule.processPhoneCaseOrder(phoneCaseList);
		}
		
		//Business Rule: There is 10% discount on SamZung products.
		phoneMakerRule.applyProductMakerRule(phoneList);
		phoneCaseMakerRule.applyProductMakerRule(phoneCaseList);
		simMakerRule.applyProductMakerRule(simList);
		televisionMakerRule.applyProductMakerRule(tvList);
		
		//Business Rule: Insurance is discounted 25% for any product over 400.
		//Business Rule: Insurance is discounted 15% on phones.
		//Business Rule: Insurance discounts are not cumulative. 
		List<Product> insuranceAppliedList = insuranceBusinessRule.getInsuranceForProducts(productInputListCopy, productMasterList);
		
		List<Product> finalListOfProducts = new ArrayList<Product>();
		finalListOfProducts.addAll(simList);
		finalListOfProducts.addAll(phoneList);
		finalListOfProducts.addAll(tvList);
		finalListOfProducts.addAll(phoneCaseList);
		finalListOfProducts.addAll(insuranceAppliedList);
		
		//Business Rule: Apply 14% VAT.
		globalBusinessRule.applyCommonBusinessRule(finalListOfProducts);
		
		Cart cart = new Cart();
		
		cart.setOrders(translateProductToOrder(finalListOfProducts));
		cart.setTotalPrice(DataUtil.getTotalPrice(finalListOfProducts));
		cart.setMessage(CART_SUCCESSFUL_MESSAGE);
		
		
		return cart;
	}
	
	private List<Product> getPhoneList(List<Product> productList){
		List<Product> phoneList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getCategoryId().equals(ProductCategory.PHONE.getCategoryId())) {
				phoneList.add(product);
			}
		}
		return phoneList;
	}
	
	private List<Product> getSimList(List<Product> productList){
		List<Product> simList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getCategoryId().equals(ProductCategory.SIM.getCategoryId())) {
				simList.add(product);
			}
		}
		return simList;
	}
	
	private List<Product> getTvList(List<Product> productList){
		List<Product> tvList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getCategoryId().equals(ProductCategory.TELEVISION.getCategoryId())) {
				tvList.add(product);
			}
		}
		return tvList;
	}
	
	private List<Product> getPhoneCaseList(List<Product> productList){
		List<Product> phoneCaseList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getCategoryId().equals(ProductCategory.PHONE_CASE.getCategoryId())) {
				phoneCaseList.add(product);
			}
		}
		return phoneCaseList;
	}
	
}
