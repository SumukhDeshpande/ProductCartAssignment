package com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces;

import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public interface GlobalRule {
	
	public void applyCommonBusinessRule(List<Product> productList);

}
