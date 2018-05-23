package com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces;

import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public interface PhoneCaseRule {
	
	public List<Product> processPhoneCaseOrder(List<Product> phoneCaseList);

}
