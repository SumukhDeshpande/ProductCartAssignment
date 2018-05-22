package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMultiplePhoneCases;
import static org.junit.Assert.assertTrue;

public class PhoneCaseMakerBusinessRuleTest {
	
	
	@Test
	public void testPhoneCaseBusinessRuleForSamZung() {
		
		PhoneCaseMakerRule phoneCaseMakerRule = new PhoneCaseMakerRule();
		
		List<Product> phoneCaseList = new ArrayList<Product>();
		
		phoneCaseList = getMultiplePhoneCases(1);
		
		phoneCaseList.get(0).setMaker("SamZung");
		
		Product phoneCaseMasterDetails = new Product();
		phoneCaseMasterDetails.setId(10004L);
		phoneCaseMasterDetails.setMaker("Phone Case");
		phoneCaseMasterDetails.setModel("Some Phone Case");
		phoneCaseMasterDetails.setName("Plastic");
		phoneCaseMasterDetails.setDescription("This is a Plastic Phone Case.");
		phoneCaseMasterDetails.setPrice(150);
		phoneCaseMasterDetails.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());
		
		phoneCaseMakerRule.applyProductMakerRule(phoneCaseList, phoneCaseMasterDetails);
		
		assertTrue(phoneCaseList.get(0).getPrice() == 135.0);
		
		
		
	}
	
	
	@Test
	public void testPhoneCaseBusinessRuleForNonSamZungProduct() {
		
		PhoneCaseMakerRule phoneCaseMakerRule = new PhoneCaseMakerRule();
		
		List<Product> phoneCaseList = new ArrayList<Product>();
		
		phoneCaseList = getMultiplePhoneCases(1);
		
		Product phoneCaseMasterDetails = new Product();
		phoneCaseMasterDetails.setId(10004L);
		phoneCaseMasterDetails.setMaker("Phone Case");
		phoneCaseMasterDetails.setModel("Some Phone Case");
		phoneCaseMasterDetails.setName("Plastic");
		phoneCaseMasterDetails.setDescription("This is a Plastic Phone Case.");
		phoneCaseMasterDetails.setPrice(150);
		phoneCaseMasterDetails.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());
		
		phoneCaseMakerRule.applyProductMakerRule(phoneCaseList, phoneCaseMasterDetails);
		
		assertTrue(phoneCaseList.get(0).getPrice() == 150);
		
		
		
	}


}
