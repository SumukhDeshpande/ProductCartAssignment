package com.worstbuy.assignment.worstbuyshoppingcart.validator;

import org.junit.Test;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getSimList;

public class SimValidatorTest {
	
	@Test(expected = ValidationException.class)
	public void testValidationException() throws ValidationException {
		SimValidator simValidator = new SimValidator();
		
		simValidator.validateSim(getSimList(11));
		
	}

}
