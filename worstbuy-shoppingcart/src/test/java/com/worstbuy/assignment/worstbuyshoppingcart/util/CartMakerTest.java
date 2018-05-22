package com.worstbuy.assignment.worstbuyshoppingcart.util;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.GlobalRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.InsuranceRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.PhoneCaseRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.ProductMakerRule;
import com.worstbuy.assignment.worstbuyshoppingcart.businessrule.interfaces.SimRule;
import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.validator.SimValidator;
import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMasterProductList;

@RunWith(MockitoJUnitRunner.class)
public class CartMakerTest {

	@Mock
	SimValidator simValidator;

	@Mock
	SimRule simBusinessRule;

	@Mock
	PhoneCaseRule phoneCaseBusinessRule;

	@Mock
	ProductMakerRule phoneCaseMakerRule;

	@Mock
	ProductMakerRule phoneMakerRule;

	@Mock
	ProductMakerRule simMakerRule;

	@Mock
	ProductMakerRule televisionMakerRule;

	@Mock
	InsuranceRule insuranceBusinessRule;

	@Mock
	GlobalRule globalBusinessRule;

	@InjectMocks
	CartMaker cartMaker = new CartMaker();

	@Test
	public void testCartMaking() throws ValidationException {
		
		List<Product> simList = new ArrayList<Product>();

		List<Product> productList = new ArrayList<Product>();

		Product phone = new Product();
		phone.setId(10001L);
		phone.setMaker("SamZung");
		phone.setModel("SamZung-J7-4GLTE");
		phone.setName("SamZung-J7");
		phone.setPrice(1000);
		phone.setDescription("SamZung-4G-latest-phone.");
		phone.setCategoryId(ProductCategory.PHONE.getCategoryId());
		phone.setInsuranceRequired(true);
		
		productList.add(phone);

		cartMaker.createCart(productList, getMasterProductList());
		
		verify(simValidator).validateSim(simList);

	}

}
