package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMultiplePhoneCases;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public class PhoneCaseBusinessRuleTest {
	
	
	@Test
	public void testPhoneCaseBusinessRule() {
		
		PhoneCaseBusinessRule phoneCaseBusinessRule = new PhoneCaseBusinessRule();
		
		List<Product> phoneCaseList = getMultiplePhoneCases(3);
		
		List<Product> phoneListProcessed = phoneCaseBusinessRule.processPhoneCaseOrder(phoneCaseList);
		
		assertTrue(phoneListProcessed.size() == 7);
		
	}
	
	@Test
	public void testPhoneCaseBusinessRuleForLessThan3sMultiple() {
		
		PhoneCaseBusinessRule phoneCaseBusinessRule = new PhoneCaseBusinessRule();
		
		List<Product> phoneCaseList = getMultiplePhoneCases(5);
		
		List<Product> phoneListProcessed = phoneCaseBusinessRule.processPhoneCaseOrder(phoneCaseList);
		
		assertTrue(phoneListProcessed.size() == 9);
		
	}
	
	

}
