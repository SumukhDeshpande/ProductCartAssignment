package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil;

@Component
public class SimBusinessRule {

	public List<Product> processSimOrder(List<Product> simList, List<Product> phoneList) {

		int phonesOrdered = phoneList.size();
		int simCardsOrdered = simList.size();

		// Sim Card free for each phone ordered.
		for (int i = 0; i < phonesOrdered; i++) {
			if (simList.size() <= 10) {
				simList.add(DataUtil.getFreeSim());
			}
		}

		// One Sim Card free for each Sim Card ordered.
		for (int i = 0; i < simCardsOrdered; i++) {
			if (simList.size() <= 10) {
				simList.add(DataUtil.getFreeSim());
			}
		}
		
		
		return simList;

	}

}
