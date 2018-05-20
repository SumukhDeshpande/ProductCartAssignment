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
@Qualifier("televisionMakerRule")
public class TelevisionMakerRule implements ProductMakerRule{

	@Override
	public void applyProductMakerRule(List<Product> tvList, Product tvProduct) {

		tvList.forEach(product -> {
			if (product.getMaker().equals(SAMZUNG) ) {
				product.setPrice(calculateDiscount(tvProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else {
				product.setPrice(tvProduct.getPrice());
			}
		});

	}

}
