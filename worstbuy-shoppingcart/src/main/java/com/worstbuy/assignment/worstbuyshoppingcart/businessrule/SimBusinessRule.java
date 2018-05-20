package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.SimRule;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getFreeSim;

@Component
public class SimBusinessRule implements SimRule{

	public List<Product> processSimOrder(List<Product> simList, List<Product> phoneList, Product simMasterProduct) {

		int phonesOrdered = phoneList.size();
		int simCardsOrdered = simList.size();

		// Sim Card free for each phone ordered.
		for (int i = 0; i < phonesOrdered; i++) {
			if (simList.size() <= 10) {
				simList.add(getFreeSim());
			}
		}

		// One Sim Card free for each Sim Card ordered.
		for (int i = 0; i < simCardsOrdered; i++) {
			if (simList.size() <= 10) {
				simList.add(getFreeSim());
			}
			simList.get(i).setPrice(simMasterProduct.getPrice());
		}
		
		
		return simList;

	}

}
