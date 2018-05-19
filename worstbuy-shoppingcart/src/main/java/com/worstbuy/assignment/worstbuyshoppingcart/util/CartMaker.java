package com.worstbuy.assignment.worstbuyshoppingcart.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.GlobalBusinessRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.InsuranceBusinessRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.PhoneCaseBusinessRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.ProductMakerBusinessRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.SimBusinessRule;
import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.validator.SimValidator;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.translateProductToOrder;

@Component
public class CartMaker {

	@Autowired
	SimValidator simValidator;
	
	@Autowired
	SimBusinessRule simBusinessRule;
	
	@Autowired
	PhoneCaseBusinessRule phoneCaseBusinessRule;
	
	@Autowired
	ProductMakerBusinessRule productMakerBusinessRule;
	
	@Autowired
	InsuranceBusinessRule insuranceBusinessRule;
	
	@Autowired
	GlobalBusinessRule globalBusinessRule;

	public Cart createCart(List<Product> productListInput, List<Product> productMasterList) throws ValidationException {

		List<Product> phoneList = new ArrayList<Product>();
		List<Product> tvList = new ArrayList<Product>();
		List<Product> phoneCaseList = new ArrayList<Product>();
		List<Product> simList = new ArrayList<Product>();
		
		List<Product> productInputListCopy = new ArrayList<Product>();
		
		productInputListCopy.addAll(productListInput);
		
		for (Product product : productInputListCopy) {
			if (product.getCategoryId().equals(ProductCategory.PHONE.getCategoryId())) {
				phoneList.add(product);
			} else if (product.getCategoryId().equals(ProductCategory.TELEVISION.getCategoryId())) {
				tvList.add(product);
			}else if (product.getCategoryId().equals(ProductCategory.PHONE_CASE.getCategoryId())) {
				phoneCaseList.add(product);
			} else if (product.getCategoryId().equals(ProductCategory.SIM.getCategoryId())) {
				simList.add(product);
			}
		}

		
		Product insuranceProduct = null;
		Product simProduct = null;
		Product phoneProduct = null;
		Product tvProduct = null;
		Product phoneCaseProduct = null;

		for (Product product : productMasterList) {
			if (product.getCategoryId().equals(ProductCategory.PHONE.getCategoryId())) {
				phoneProduct = product;
			} else if (product.getCategoryId().equals(ProductCategory.TELEVISION.getCategoryId())) {
				tvProduct = product;
			}else if (product.getCategoryId().equals(ProductCategory.PHONE_CASE.getCategoryId())) {
				phoneCaseProduct = product;
			} else if (product.getCategoryId().equals(ProductCategory.SIM.getCategoryId())) {
				simProduct = product;
			}  else if (product.getCategoryId().equals(ProductCategory.INSURANCE.getCategoryId())) {
				insuranceProduct = product;
			}
		}

		//Business Rule: The law prevents anyone buying more than 10 SIM cards in a single purchase.
		
		simValidator.validateSim(simList);
		
		//Business Rule: One Sim card is added for free for each phone sold.
		//Business Rule: SimCard sold on their own(not with the phone) are "Buy one get One Free".
		simBusinessRule.processSimOrder(simList, phoneList);
		
		//Business Rule: There is a "Buy 3 get 4" on phone cases.
		if(!phoneCaseList.isEmpty()) {
			phoneCaseBusinessRule.processPhoneCaseOrder(phoneCaseList);
		}
		
		//Business Rule: There is 10% discount on SamZung products.
		productMakerBusinessRule.applyProductMakerRuleForPhone(phoneList, phoneProduct);
		productMakerBusinessRule.applyProductMakerRuleForPhoneCases(phoneCaseList, phoneCaseProduct);
		productMakerBusinessRule.applyProductMakerRuleForSim(simList, simProduct);
		productMakerBusinessRule.applyProductMakerRuleForTelevisions(tvList, tvProduct);
		
		//Business Rule: Insurance is discounted 25% for any product over 400.
		//Business Rule: Insurance is discounted 15% on phones.
		//Business Rule: Insurance discounts are not cumulative. 
		List<Product> insuranceAppliedList = insuranceBusinessRule.getInsuranceForProducts(productInputListCopy, insuranceProduct);
		
		List<Product> finalListOfProducts = new ArrayList<Product>();
		finalListOfProducts.addAll(simList);
		finalListOfProducts.addAll(phoneList);
		finalListOfProducts.addAll(tvList);
		finalListOfProducts.addAll(phoneCaseList);
		finalListOfProducts.addAll(insuranceAppliedList);
		
		//Business Rule: Apply 14% VAT.
		globalBusinessRule.applyCommonBusinessRule(finalListOfProducts);
		
		Cart cart = new Cart();
		
		cart.setOrders(translateProductToOrder(finalListOfProducts));
		cart.setTotalPrice(DataUtil.getTotalPrice(finalListOfProducts));
		
		
		return cart;
	}

}
