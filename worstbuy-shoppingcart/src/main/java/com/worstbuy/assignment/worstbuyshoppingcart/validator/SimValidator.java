package com.worstbuy.assignment.worstbuyshoppingcart.validator;

import java.util.List;
import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.MAXIMUM_SIM_ORDER_LIMIT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SIM_CARD_ORDER_LIMIT_VALIDATION_MESSAGE;

@Component
public class SimValidator {
	
	public void validateSim(List<Product> simList) throws ValidationException {
		
		if(simList.size() > MAXIMUM_SIM_ORDER_LIMIT) {
			throw new ValidationException(SIM_CARD_ORDER_LIMIT_VALIDATION_MESSAGE);
		}
		
	}

}
