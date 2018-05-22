package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMasterProductList;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getSampleProductList;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

public class InsuranceBusinessRuleTest {

	@Test
	public void testInsuranceBusinessRule() {
		InsuranceBusinessRule insuranceBusinessRule = new InsuranceBusinessRule();

		List<Product> insuranceProductList = insuranceBusinessRule.getInsuranceForProducts(getSampleProductList(), getMasterProductList());
		
		assertTrue(insuranceProductList.size() == 3);
		
		
	}

}
