package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.SimRule;
import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.MAXIMUM_SIM_ORDER_LIMIT;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.Constants.SIM_CARD_ORDER_LIMIT_VALIDATION_MESSAGE;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getFreeSim;

@Component
public class SimBusinessRule implements SimRule{

	public List<Product> processSimOrder(List<Product> simList, List<Product> phoneList) throws ValidationException {

		int phonesOrdered = phoneList.size();
		int simCardsOrdered = simList.size();

		// Sim Card free for each phone ordered.
		for (int i = 0; i < phonesOrdered; i++) {
				simList.add(getFreeSim());
		}

		// One Sim Card free for each Sim Card ordered.
		for (int i = 0; i < simCardsOrdered; i++) {
				simList.add(getFreeSim());
		}
		
		if(simList.size() > MAXIMUM_SIM_ORDER_LIMIT) {
			throw new ValidationException(SIM_CARD_ORDER_LIMIT_VALIDATION_MESSAGE);
		}
		
		
		return simList;

	}

}
