package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.VAT;

@Component
public class GlobalBusinessRule {

	public void applyCommonBusinessRule(List<Product> productList) {
		
		//The Insurance and Free products should be exempted from VAT.
		productList.forEach(product -> {
			if ((!product.getCategoryId().equals(ProductCategory.INSURANCE.getCategoryId())) && product.getPrice() > 0) {
				product.setPrice(product.getPrice() + (product.getPrice() * VAT));
			}
		});
	}
}
