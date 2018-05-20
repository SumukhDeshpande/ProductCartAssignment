package com.worstbuy.assignment.worstbuyshoppingcart.businessrule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.PhoneCaseRule;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.DataUtil.getFreePhoneCase;

@Component
public class PhoneCaseBusinessRule implements PhoneCaseRule{
	
	public List<Product> processPhoneCaseOrder(List<Product> phoneCaseList, Product phoneCaseMasterDetails){
		//For every 3 Phone Cases you get 4 Phone Cases free. 
		//So for example: When 6 Phone Cases are Ordered you get 8 free.
		// 6 / 3 = 2 in turn 2 * 4 which comes 8. 
		int freePhoneCaseMultiplier = phoneCaseList.size() / 3;
		
		int freePhoneCaseQuantity = freePhoneCaseMultiplier * 4;
		
		phoneCaseList.forEach(product -> product.setPrice(phoneCaseMasterDetails.getPrice()));
		
		for(int i = 0; i < freePhoneCaseQuantity; i++) {
			phoneCaseList.add(getFreePhoneCase());
		}
		
		return phoneCaseList;
	}

}
