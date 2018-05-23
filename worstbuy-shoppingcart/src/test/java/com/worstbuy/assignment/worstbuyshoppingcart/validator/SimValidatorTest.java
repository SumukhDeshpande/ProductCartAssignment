package com.worstbuy.assignment.worstbuyshoppingcart.validator;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getSimList;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class SimValidatorTest {
	
	@Test(expected = ValidationException.class)
	public void testValidationException() throws ValidationException {
		SimValidator simValidator = new SimValidator();
		
		simValidator.validateSim(getSimList(11));
		
	}
	
	@Test
	public void testSimValidationWithoutException() throws ValidationException {
		SimValidator simValidator = new SimValidator();
		List<Product> simList = getSimList(4);
		simValidator.validateSim(simList);
		
		assertEquals(4, simList.size());
		
	}

}
