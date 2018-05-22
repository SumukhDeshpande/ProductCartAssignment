package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;
import org.junit.Test;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMultiplePhoneCases;
import static org.junit.Assert.assertTrue;

public class PhoneCaseBusinessRuleTest {
	
	
	@Test
	public void testPhoneCaseBusinessRule() {
		
		PhoneCaseBusinessRule phoneCaseBusinessRule = new PhoneCaseBusinessRule();
		
		List<Product> phoneCaseList = getMultiplePhoneCases(3);
		
		Product phoneCaseMasterDetails = new Product();
		phoneCaseMasterDetails.setId(10004L);
		phoneCaseMasterDetails.setMaker("Phone Case");
		phoneCaseMasterDetails.setModel("Some Phone Case");
		phoneCaseMasterDetails.setName("Plastic");
		phoneCaseMasterDetails.setDescription("This is a Plastic Phone Case.");
		phoneCaseMasterDetails.setPrice(150);
		phoneCaseMasterDetails.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());
		
		List<Product> phoneListProcessed = phoneCaseBusinessRule.processPhoneCaseOrder(phoneCaseList, phoneCaseMasterDetails);
		
		assertTrue(phoneListProcessed.size() == 7);
		
	}
	
	

}
