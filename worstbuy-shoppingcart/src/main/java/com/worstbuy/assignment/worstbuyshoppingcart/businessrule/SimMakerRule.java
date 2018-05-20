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
@Qualifier("simMakerRule")
public class SimMakerRule implements ProductMakerRule{

	@Override
	public void applyProductMakerRule(List<Product> simList, Product simProduct) {

		simList.forEach(product -> {
			// We should not be applying discounts on Free products.
			if (product.getMaker().equals(SAMZUNG) && product.getPrice() != 0) {
				product.setPrice(calculateDiscount(simProduct.getPrice(), SAMZUNG_DISCOUNT));
			} else if(product.getPrice() != 0){
				product.setPrice(simProduct.getPrice());
			}
		});

	}

}
