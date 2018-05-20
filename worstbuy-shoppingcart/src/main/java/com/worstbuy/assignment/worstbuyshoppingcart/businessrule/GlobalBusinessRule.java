package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.GlobalRule;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.VAT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.checkProductIsInsuranceOrFree;

@Component
public class GlobalBusinessRule implements GlobalRule{

	public void applyCommonBusinessRule(List<Product> productList) {
		
		//The Insurance and Free products should be exempted from VAT.
		productList.forEach(product -> {
			if (!checkProductIsInsuranceOrFree(product)) {
				product.setPrice(product.getPrice() + (product.getPrice() * VAT));
			}
		});
	}
}
