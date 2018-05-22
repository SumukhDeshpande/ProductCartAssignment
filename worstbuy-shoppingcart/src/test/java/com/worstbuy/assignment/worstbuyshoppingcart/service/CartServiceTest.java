package com.worstbuy.assignment.worstbuyshoppingcart.service;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMasterProductList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Order;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.repositories.ProductRepository;
import com.worstbuy.assignment.worstbuyshoppingcart.util.CartMaker;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

	@Mock
	CartMaker cartMaker;

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	CartService cartService = new CartService();

	@Test
	public void testCreateCart() throws ValidationException {

		List<Product> productMasterList = getMasterProductList();

		when(productRepository.findAll()).thenReturn(productMasterList);
		
		List<Product> productListInput = new ArrayList<Product>();
		Product phoneProduct = new Product();
		phoneProduct.setId(10001L);
		phoneProduct.setMaker("SamZung");
		phoneProduct.setModel("SamZung-J7-4GLTE");
		phoneProduct.setName("SamZung-J7");
		phoneProduct.setPrice(1000);
		phoneProduct.setDescription("SamZung-4G-latest-phone.");
		phoneProduct.setCategoryId(ProductCategory.PHONE.getCategoryId());
		phoneProduct.setInsuranceRequired(true);
		
		productListInput.add(phoneProduct);
		
		Cart cart = new Cart();
		Order order = new Order();
		order.setMaker("Samsung");
		order.setModel("Samsung-J7-4GLTE");
		order.setName("Samsung-J7");
		order.setPrice(1000);
		order.setDescription("Samsung-4G-latest-phone.");
		order.setCategoryId(1L);
		List<Order> mockProductList = new ArrayList<Order>();
		mockProductList.add(order);
		
		cart.setOrders(mockProductList);
		cart.setTotalPrice(1425);
		
		when(cartMaker.createCart(productListInput, productMasterList)).thenReturn(cart);
		
		Cart cartReturned = cartService.createCart(productListInput);
		
		assertEquals(cart, cartReturned);

	}

}
