package com.worstbuy.assignment.worstbuyshoppingcart.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public class CartValidator {
	
	@Autowired
	InsuranceValidator insuranceValidator;
	
	@Autowired
	PhoneValidator phoneValidator;
	
	@Autowired
	SimValidator simValidator;
	
	@Autowired
	TelevisionValidator televisionValidator;
	
	public Cart validateCart(List<Product> products) {
		return null;
	}

}
