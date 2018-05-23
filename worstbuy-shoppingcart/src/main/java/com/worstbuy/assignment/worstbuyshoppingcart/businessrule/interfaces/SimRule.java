package com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces;

import java.util.List;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public interface SimRule {
	
	public List<Product> processSimOrder(List<Product> simList, List<Product> phoneList)  throws ValidationException ;

}
