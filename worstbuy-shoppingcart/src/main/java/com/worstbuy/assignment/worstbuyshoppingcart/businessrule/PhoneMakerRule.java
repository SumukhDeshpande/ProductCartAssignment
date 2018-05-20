package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SAMZUNG;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SAMZUNG_DISCOUNT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.calculateDiscount;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.ProductMakerRule;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

@Component
@Qualifier("phoneMakerRule")
public class PhoneMakerRule implements ProductMakerRule{
	
	@Override
	public void applyProductMakerRule(List<Product> phoneList, Product phoneProduct) {

		phoneList.forEach(product -> {
			if (product.getMaker().equals(SAMZUNG)) {
				product.setPrice(calculateDiscount(phoneProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else {
				product.setPrice(phoneProduct.getPrice());
			}
		});

	}

}
