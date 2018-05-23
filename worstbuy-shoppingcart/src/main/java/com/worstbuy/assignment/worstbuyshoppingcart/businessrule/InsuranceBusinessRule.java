package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getInsuranceForPhone;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getInsuranceForPhoneCase;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getInsuranceForSim;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getInsuranceForTv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.InsuranceRule;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

@Component
public class InsuranceBusinessRule implements InsuranceRule{
	
	
	public List<Product> getInsuranceForProducts(List<Product> productList, List<Product> productMasterList){
		List<Product> productsWithInsuranceList = productList.stream().filter(product -> product.isInsuranceRequired())
				.collect(Collectors.toList());
		
		List<Product> insuranceAppliedList = new ArrayList<Product>();
		
		Product insuranceProduct = null;
		
		for (Product product : productMasterList) {
			if (product.getCategoryId().equals(ProductCategory.INSURANCE.getCategoryId())) {
				insuranceProduct = product;
				break;
			}
		}
		
		for(Product product: productsWithInsuranceList) {
			
			if (product.getCategoryId().equals(ProductCategory.PHONE.getCategoryId())) {
				insuranceAppliedList.add(getInsuranceForPhone(product, insuranceProduct));
			} else if (product.getCategoryId().equals(ProductCategory.TELEVISION.getCategoryId())) {
				insuranceAppliedList.add(getInsuranceForTv(product, insuranceProduct));
			}else if (product.getCategoryId().equals(ProductCategory.PHONE_CASE.getCategoryId())) {
				insuranceAppliedList.add(getInsuranceForPhoneCase(product, insuranceProduct));
			} else if (product.getCategoryId().equals(ProductCategory.SIM.getCategoryId())) {
				insuranceAppliedList.add(getInsuranceForSim(product, insuranceProduct));
			} 
		
		}
		return insuranceAppliedList;
	}

}
