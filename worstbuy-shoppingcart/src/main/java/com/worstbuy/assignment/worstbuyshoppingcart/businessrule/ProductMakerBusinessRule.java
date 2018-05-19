package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SAMZUNG_DISCOUNT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SAMZUNG;

@Component
public class ProductMakerBusinessRule {
	
	public void applyProductMakerRules(List<Product> phoneList, List<Product> televisionList, List<Product> simList, List<Product> phoneCaseList){
		
		phoneList.forEach(product -> {
			if(product.getMaker().equals(SAMZUNG)) {
				product.setPrice(product.getPrice() * (SAMZUNG_DISCOUNT));
			}
		});
		
		televisionList.forEach(product -> {
			if(product.getMaker().equals(SAMZUNG)) {
				product.setPrice(product.getPrice() * (SAMZUNG_DISCOUNT));
			}
		});
		
		simList.forEach(product -> {
			if(product.getMaker().equals(SAMZUNG)) {
				product.setPrice(product.getPrice() * (SAMZUNG_DISCOUNT));
			}
		});
		
		phoneCaseList.forEach(product -> {
			if(product.getMaker().equals(SAMZUNG)) {
				product.setPrice(product.getPrice() * (SAMZUNG_DISCOUNT));
			}
		});
	}
}
