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
		
		phoneCaseMakerRule.applyProductMakerRule(phoneCaseList);
		
		System.out.println(phoneCaseList.get(0).getPrice());
		
		assertTrue(phoneCaseList.get(0).getPrice() == 90.0);
		
		
		
	}
	
	
	@Test
	public void testPhoneCaseBusinessRuleForNonSamZungProduct() {
		
		PhoneCaseMakerRule phoneCaseMakerRule = new PhoneCaseMakerRule();
		
		List<Product> phoneCaseList = new ArrayList<Product>();
		
		phoneCaseList = getMultiplePhoneCases(1);
		
		phoneCaseMakerRule.applyProductMakerRule(phoneCaseList);
		
		assertTrue(phoneCaseList.get(0).getPrice() == 100);
		
		
		
	}


}
