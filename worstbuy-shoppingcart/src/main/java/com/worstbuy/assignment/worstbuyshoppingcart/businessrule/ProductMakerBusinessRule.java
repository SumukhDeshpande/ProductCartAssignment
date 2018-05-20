package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SAMZUNG_DISCOUNT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SAMZUNG;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.calculateDiscount;

@Component
public class ProductMakerBusinessRule {

	public void applyProductMakerRuleForPhone(List<Product> phoneList, Product phoneProduct) {

		phoneList.forEach(product -> {
			if (product.getMaker().equals(SAMZUNG)) {
				product.setPrice(calculateDiscount(phoneProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else {
				product.setPrice(phoneProduct.getPrice());
			}
		});

	}

	public void applyProductMakerRuleForSim(List<Product> simList, Product simProduct) {

		simList.forEach(product -> {
			// We should not be applying discounts on Free products.
			if (product.getMaker().equals(SAMZUNG) && product.getPrice() != 0) {
				product.setPrice(calculateDiscount(simProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else if(product.getPrice() != 0){
				product.setPrice(simProduct.getPrice());
			}
		});

	}

	public void applyProductMakerRuleForPhoneCases(List<Product> phoneCaseList, Product phoneCaseProduct) {

		phoneCaseList.forEach(product -> {
			// We should not be applying discounts on Free products.
			if (product.getMaker().equals(SAMZUNG) && product.getPrice() != 0) {
				product.setPrice(calculateDiscount(phoneCaseProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else {
				product.setPrice(phoneCaseProduct.getPrice());
			}
		});

	}

	public void applyProductMakerRuleForTelevisions(List<Product> tvList, Product tvProduct) {

		tvList.forEach(product -> {
			if (product.getMaker().equals(SAMZUNG) ) {
				product.setPrice(calculateDiscount(tvProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else {
				product.setPrice(tvProduct.getPrice());
			}
		});

	}

}
