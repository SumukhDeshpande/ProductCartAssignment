package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.PRODUCT_PRICE;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.PRODUCT_PRICE_RELATED_INSURANCE_DISCOUNT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.PHONE_INSURANCE_DISCOUNT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getNewInsuranceProduct;

@Component
public class InsuranceBusinessRule {
	
	public List<Product> getInsuranceForProducts(List<Product> productList, Product insuranceProduct){
		List<Product> productsWithInsuranceList = productList.stream().filter(product -> product.isInsuranceRequired())
				.collect(Collectors.toList());
		
		List<Product> insuranceAppliedList = new ArrayList<Product>();
		
		for(Product product: productsWithInsuranceList) {
			boolean productIsPhone  = false;
			double discount = 1;
			if(product.getCategoryId().equals(ProductCategory.PHONE.getCategoryId())) {
				productIsPhone = true;
			}
			if(!productIsPhone && product.getPrice() > PRODUCT_PRICE) {
				discount = PRODUCT_PRICE_RELATED_INSURANCE_DISCOUNT;
			}
			if(productIsPhone && !(product.getPrice() > PRODUCT_PRICE)) {
				discount = PHONE_INSURANCE_DISCOUNT;
			}
			//Assumption is made if Product is Phone and Price > 400 then maximum of discount can be applied which is 25%
			if(productIsPhone && product.getPrice() > PRODUCT_PRICE) {
				discount = PRODUCT_PRICE_RELATED_INSURANCE_DISCOUNT;
			}
			
			insuranceAppliedList.add(getNewInsuranceProduct(insuranceProduct, discount));
		
		}
		return insuranceAppliedList;
	}

}
