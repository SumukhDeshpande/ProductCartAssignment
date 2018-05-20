package com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces;

import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public interface SimRule {
	
	public List<Product> processSimOrder(List<Product> simList, List<Product> phoneList, Product simMasterProduct);

}
