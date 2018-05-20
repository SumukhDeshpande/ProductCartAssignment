package com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces;

import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public interface InsuranceRule {
	
	public List<Product> getInsuranceForProducts(List<Product> productList, List<Product> productMasterList);

}
